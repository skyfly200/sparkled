package io.sparkled.persistence.setting.impl

import com.google.common.util.concurrent.ThreadFactoryBuilder
import com.google.inject.persist.UnitOfWork
import io.sparkled.model.entity.Setting
import io.sparkled.model.setting.SettingsCache
import io.sparkled.model.setting.SettingsConstants
import io.sparkled.persistence.QueryFactory
import io.sparkled.persistence.setting.SettingPersistenceService
import io.sparkled.persistence.setting.impl.query.GetSettingsQuery
import io.sparkled.persistence.setting.impl.query.SaveSettingQuery
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

class SettingPersistenceServiceImpl
@Inject constructor(
    private val unitOfWork: UnitOfWork,
    private val queryFactory: QueryFactory
) : SettingPersistenceService {

    private var settingsCache: SettingsCache? = null

    private var executor: ExecutorService = Executors.newSingleThreadExecutor(
        ThreadFactoryBuilder().setNameFormat("settings-cache-%d").build()
    )

    override val settings: SettingsCache
        get() {
            if (settingsCache == null) {
                reloadSettingsCache()
            }

            return settingsCache!!
        }

    /**
     * The settings cache is read and written to by multiple threads (e.g. REST API updates brightness, UDP server reads
     * new brightness). Therefore, the cache is reloaded in its own thread with its own entity manager to ensure fresh
     * data.
     */
    private fun reloadSettingsCache() {
        settingsCache = executor.submit(Callable {
            unitOfWork.begin()
            try {
                val settings = GetSettingsQuery().perform(queryFactory)
                val settingsMap = settings.associateBy({ it.getCode()!! }, { it })
                return@Callable SettingsCache(getBrightness(settingsMap))
            } finally {
                unitOfWork.end()
            }
        }).get()
    }

    override fun setBrightness(brightness: Int) {
        val setting = Setting().setCode(SettingsConstants.BRIGHTNESS.CODE).setValue(brightness.toString())
        SaveSettingQuery(setting).perform(queryFactory)
        settingsCache = SettingsCache(brightness)
    }

    private fun getBrightness(settingsMap: Map<String, Setting>): Int {
        val setting = settingsMap.getOrDefault(SettingsConstants.BRIGHTNESS.CODE, Setting())

        return try {
            val brightness = Integer.parseInt(setting.getValue())
            constrain(brightness, SettingsConstants.BRIGHTNESS.MIN, SettingsConstants.BRIGHTNESS.MAX)
        } catch (e: NumberFormatException) {
            SettingsConstants.BRIGHTNESS.MAX
        }
    }

    private fun constrain(value: Int, min: Int, max: Int): Int {
        return Math.max(min, Math.min(max, value))
    }
}