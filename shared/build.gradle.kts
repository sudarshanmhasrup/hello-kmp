import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

group = libs.versions.shared.group.get()
version = libs.versions.shared.version.get()

kotlin {
    androidLibrary {
        namespace = libs.versions.shared.androidLibrary.namespace.get()
        compileSdk = libs.versions.shared.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.shared.androidLibrary.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    js {
        browser()
        binaries.executable()
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/shared"))