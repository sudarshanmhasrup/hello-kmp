package io.github.sudarshanmhasrup.hellokmp

/**
 * Represents the current platform (Android, iOS, Desktop, Web, etc.).
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "RedundantVisibilityModifier")
public expect class Platform() {
    /**
     * Returns the name of the current platform.
     */
    public fun getPlatformName(): String
}