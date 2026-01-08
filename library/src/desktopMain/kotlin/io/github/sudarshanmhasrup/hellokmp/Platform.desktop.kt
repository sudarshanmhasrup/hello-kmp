package io.github.sudarshanmhasrup.hellokmp

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "RedundantVisibilityModifier")
public actual class Platform {
    public actual fun getPlatformName(): String {
        return "JVM ${System.getProperty("java.version")}"
    }
}