plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

group = libs.versions.library.group.get()
version = libs.versions.library.version.get()

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    // Common compiler arguments
    compilerOptions {
        freeCompilerArgs.add("-Xsuppress-warning=UNUSED")
        freeCompilerArgs.add("-Xsuppress-warning=RedundantVisibilityModifier")
    }
}