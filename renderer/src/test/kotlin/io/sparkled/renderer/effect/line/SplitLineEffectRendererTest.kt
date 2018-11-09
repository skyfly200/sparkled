package io.sparkled.renderer.effect.line

import io.sparkled.model.animation.easing.Easing
import io.sparkled.model.animation.easing.EasingTypeCode
import io.sparkled.model.animation.effect.Effect
import io.sparkled.model.animation.effect.EffectTypeCode
import io.sparkled.model.animation.fill.Fill
import io.sparkled.model.animation.fill.FillTypeCode
import io.sparkled.model.animation.param.Param
import io.sparkled.model.animation.param.ParamName
import io.sparkled.util.RenderUtils
import io.sparkled.util.matchers.SparkledMatchers.hasRenderedFrames
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import kotlin.intArrayOf as f

class SplitLineEffectRendererTest {

    @Test
    fun can_render_5_led_line_on_10_led_channel() {
        val effect = Effect()
            .setType(EffectTypeCode.SPLIT_LINE)
            .setParams(
                listOf(
                    Param().setName(ParamName.LENGTH).setValue(5)
                )
            )
            .setEasing(
                Easing().setType(EasingTypeCode.LINEAR)
            )
            .setFill(
                Fill()
                    .setType(FillTypeCode.SOLID)
                    .setParams(
                        listOf(
                            Param().setName(ParamName.COLOR).setValue("#ffffff")
                        )
                    )
            )

        val renderedStagePropData = RenderUtils.render(effect, 50, 10)

        assertThat(
            renderedStagePropData, hasRenderedFrames(
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x343434, 0x343434, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x686868, 0x686868, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x9C9C9C, 0x9C9C9C, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0xD0D0D0, 0xD0D0D0, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x050505, 0xFFFFFF, 0xFFFFFF, 0x050505, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x393939, 0xFFFFFF, 0xFFFFFF, 0x393939, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x6D6D6D, 0xFFFFFF, 0xFFFFFF, 0x6D6D6D, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0xA1A1A1, 0xFFFFFF, 0xFFFFFF, 0xA1A1A1, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0xD5D5D5, 0xFFFFFF, 0xFFFFFF, 0xD5D5D5, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x0A0A0A, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x0A0A0A, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x3E3E3E, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x3E3E3E, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x727272, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x727272, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0xA7A7A7, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xA7A7A7, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0xDBDBDB, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xDBDBDB, 0x000000, 0x000000),
                f(0x000000, 0x101010, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x101010, 0x000000),
                f(0x000000, 0x444444, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x444444, 0x000000),
                f(0x000000, 0x787878, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x787878, 0x000000),
                f(0x000000, 0xACACAC, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xACACAC, 0x000000),
                f(0x000000, 0xE0E0E0, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xE0E0E0, 0x000000),
                f(0x151515, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x151515),
                f(0x494949, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x494949),
                f(0x7D7D7D, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x7D7D7D),
                f(0xB1B1B1, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xB1B1B1),
                f(0xE5E5E5, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xE5E5E5),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xE5E5E5, 0xE5E5E5, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xB1B1B1, 0xB1B1B1, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x7D7D7D, 0x7D7D7D, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x494949, 0x494949, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x151515, 0x151515, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xE0E0E0, 0x000000, 0x000000, 0xE0E0E0, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xACACAC, 0x000000, 0x000000, 0xACACAC, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x787878, 0x000000, 0x000000, 0x787878, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x444444, 0x000000, 0x000000, 0x444444, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x101010, 0x000000, 0x000000, 0x101010, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xDBDBDB, 0x000000, 0x000000, 0x000000, 0x000000, 0xDBDBDB, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xA7A7A7, 0x000000, 0x000000, 0x000000, 0x000000, 0xA7A7A7, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0x727272, 0x000000, 0x000000, 0x000000, 0x000000, 0x727272, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0x3E3E3E, 0x000000, 0x000000, 0x000000, 0x000000, 0x3E3E3E, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0x0A0A0A, 0x000000, 0x000000, 0x000000, 0x000000, 0x0A0A0A, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xD5D5D5, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xD5D5D5, 0xFFFFFF),
                f(0xFFFFFF, 0xA1A1A1, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xA1A1A1, 0xFFFFFF),
                f(0xFFFFFF, 0x6D6D6D, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x6D6D6D, 0xFFFFFF),
                f(0xFFFFFF, 0x393939, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x393939, 0xFFFFFF),
                f(0xFFFFFF, 0x050505, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x050505, 0xFFFFFF),
                f(0xD0D0D0, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xD0D0D0),
                f(0x9C9C9C, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x9C9C9C),
                f(0x686868, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x686868),
                f(0x343434, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x343434),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000)
            )
        )
    }

    @Test
    fun can_render_5_led_line_on_9_led_channel() {
        val effect = Effect()
            .setType(EffectTypeCode.SPLIT_LINE)
            .setParams(
                listOf(
                    Param().setName(ParamName.LENGTH).setValue(5)
                )
            )
            .setEasing(
                Easing().setType(EasingTypeCode.LINEAR)
            )
            .setFill(
                Fill()
                    .setType(FillTypeCode.SOLID)
                    .setParams(
                        listOf(
                            Param().setName(ParamName.COLOR).setValue("#ffffff")
                        )
                    )
            )

        val renderedStagePropData = RenderUtils.render(effect, 50, 9)

        assertThat(
            renderedStagePropData, hasRenderedFrames(
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x686868, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0xD0D0D0, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0xFFFFFF, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0xFFFFFF, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x050505, 0xFFFFFF, 0x050505, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x393939, 0xFFFFFF, 0x393939, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x6D6D6D, 0xFFFFFF, 0x6D6D6D, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0xA1A1A1, 0xFFFFFF, 0xA1A1A1, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0xD5D5D5, 0xFFFFFF, 0xD5D5D5, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x0A0A0A, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x0A0A0A, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x3E3E3E, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x3E3E3E, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x727272, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x727272, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0xA7A7A7, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xA7A7A7, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0xDBDBDB, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xDBDBDB, 0x000000, 0x000000),
                f(0x000000, 0x101010, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x101010, 0x000000),
                f(0x000000, 0x444444, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x444444, 0x000000),
                f(0x000000, 0x787878, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x787878, 0x000000),
                f(0x000000, 0xACACAC, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xACACAC, 0x000000),
                f(0x000000, 0xE0E0E0, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xE0E0E0, 0x000000),
                f(0x151515, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x151515),
                f(0x494949, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x494949),
                f(0x7D7D7D, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x7D7D7D),
                f(0xB1B1B1, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xB1B1B1),
                f(0xE5E5E5, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xE5E5E5),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFAFAFA, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x929292, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x2A2A2A, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xE0E0E0, 0x000000, 0xE0E0E0, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xACACAC, 0x000000, 0xACACAC, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x787878, 0x000000, 0x787878, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x444444, 0x000000, 0x444444, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x101010, 0x000000, 0x101010, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xDBDBDB, 0x000000, 0x000000, 0x000000, 0xDBDBDB, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xA7A7A7, 0x000000, 0x000000, 0x000000, 0xA7A7A7, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0x727272, 0x000000, 0x000000, 0x000000, 0x727272, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0x3E3E3E, 0x000000, 0x000000, 0x000000, 0x3E3E3E, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0x0A0A0A, 0x000000, 0x000000, 0x000000, 0x0A0A0A, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xD5D5D5, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xD5D5D5, 0xFFFFFF),
                f(0xFFFFFF, 0xA1A1A1, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xA1A1A1, 0xFFFFFF),
                f(0xFFFFFF, 0x6D6D6D, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x6D6D6D, 0xFFFFFF),
                f(0xFFFFFF, 0x393939, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x393939, 0xFFFFFF),
                f(0xFFFFFF, 0x050505, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x050505, 0xFFFFFF),
                f(0xD0D0D0, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xD0D0D0),
                f(0x9C9C9C, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x9C9C9C),
                f(0x686868, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x686868),
                f(0x343434, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x343434),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000)
            )
        )
    }
}