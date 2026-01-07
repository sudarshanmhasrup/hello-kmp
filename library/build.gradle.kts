plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

group = libs.versions.library.group.get()
version = libs.versions.library.version.get()

kotlin {
    jvm("desktop")

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    js {
        browser()
        binaries.executable()
    }
}