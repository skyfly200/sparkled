package io.sparkled.model.animation.param

enum class ParamCode constructor(val displayName: String) {
    NONE("None"),
    BLEND_HARDNESS("Blend Hardness (%)"),
    BRIGHTNESS("Brightness (%)"),
    COLOR("Color"),
    COLORS("Colors"),
    CYCLE_COUNT("Cycle Count"),
    CYCLES_PER_SECOND("Cycles Per Second"),
    DENSITY("Density (%)"),
    LENGTH("Length"),
    LIFETIME("Lifetime (Seconds)"),
    PERCENT_FROM("From (%)"),
    PERCENT_TO("To (%)"),
    RANDOM_SEED("Random Seed"),
    SEGMENTS("Number of Segments"),
}
