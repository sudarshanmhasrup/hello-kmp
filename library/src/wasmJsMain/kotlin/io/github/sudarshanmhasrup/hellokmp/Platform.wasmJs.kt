package io.github.sudarshanmhasrup.hellokmp

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "RedundantVisibilityModifier")
public actual class Platform {
    public actual fun getPlatformName(): String {
        return "Web with Kotlin/WASM"
    }

    public actual fun getPlatformType(): PlatformType {
        return PlatformType.Wasm
    }
}