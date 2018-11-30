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

internal class LineEffectRendererTest {

    @Test
    fun can_render_3_led_line_on_10_led_channel() {
        val effect = Effect()
            .setType(EffectTypeCode.LINE)
            .setParams(
                listOf(Param().setName(ParamName.LENGTH).setValue(3))
            )
            .setEasing(
                Easing().setType(EasingTypeCode.LINEAR)
            )
            .setFill(
                Fill()
                    .setType(FillTypeCode.SOLID)
                    .setParams(
                        listOf(Param().setName(ParamName.COLOR).setValue("#ff0000"))
                    )
            )

        val renderedStagePropData = RenderUtils.render(effect, 20, 10)

        assertThat(
            renderedStagePropData, hasRenderedFrames(
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0xAE0000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0xFF0000, 0x5E0000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0xFF0000, 0xFF0000, 0x0D0000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0xFF0000, 0xFF0000, 0xBC0000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x940000, 0xFF0000, 0xFF0000, 0x6B0000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0xE40000, 0xFF0000, 0xFF0000, 0x1B0000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x360000, 0xFF0000, 0xFF0000, 0xC90000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x860000, 0xFF0000, 0xFF0000, 0x790000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0xD70000, 0xFF0000, 0xFF0000, 0x280000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x280000, 0xFF0000, 0xFF0000, 0xD70000, 0x000000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x790000, 0xFF0000, 0xFF0000, 0x860000, 0x000000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xC90000, 0xFF0000, 0xFF0000, 0x360000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x1B0000, 0xFF0000, 0xFF0000, 0xE40000, 0x000000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x6B0000, 0xFF0000, 0xFF0000, 0x940000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xBC0000, 0xFF0000, 0xFF0000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x0D0000, 0xFF0000, 0xFF0000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x5E0000, 0xFF0000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xAE0000),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000)
            )
        )
    }

    @Test
    fun can_render_20_led_line_on_10_led_channel() {
        val effect = Effect()
            .setType(EffectTypeCode.LINE)
            .setParams(
                listOf(
                    Param().setName(ParamName.LENGTH).setValue(20)
                )
            )
            .setEasing(
                Easing()
                    .setType(EasingTypeCode.LINEAR)
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

        val renderedStagePropData = RenderUtils.render(effect, 20, 10)

        assertThat(
            renderedStagePropData, hasRenderedFrames(
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0xFFFFFF, 0x949494, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x282828, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xBCBCBC, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x515151, 0x000000, 0x000000, 0x000000),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xE4E4E4, 0x000000, 0x000000),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0x797979),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0x797979, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0x000000, 0x000000, 0xE4E4E4, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0x000000, 0x000000, 0x000000, 0x515151, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0xBCBCBC, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x282828, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x949494, 0xFFFFFF),
                f(0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000, 0x000000)
            )
        )
    }
}
