package io.github.sudarshanmhasrup.hellokmp

import platform.UIKit.UIDevice

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "RedundantVisibilityModifier")
public actual class Platform {
    public actual fun getPlatformName(): String {
        return UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    }

    public actual fun getPlatformType(): PlatformType {
        return PlatformType.Ios
    }
}