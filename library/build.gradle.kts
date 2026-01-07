import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.maven.publish)
}

group = libs.versions.library.group.get()
version = libs.versions.library.version.get()

kotlin {
    androidLibrary {
        namespace = libs.versions.library.androidLibrary.namespace.get()
        compileSdk = libs.versions.library.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.library.androidLibrary.minSdk.get().toInt()
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