package io.github.sudarshanmhasrup.hellokmp

import android.os.Build

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "RedundantVisibilityModifier")
public actual class Platform {
    public actual fun getPlatformName(): String {
        return "Android ${Build.VERSION.SDK_INT}"
    }

    public actual fun getPlatformType(): PlatformType {
        return PlatformType.Android
    }
}