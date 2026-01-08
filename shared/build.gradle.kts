import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
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

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    js {
        browser()
        binaries.executable()
    }

    sourceSets {
        val desktopMain by getting
        commonMain.dependencies {
            implementation(projects.library)
        }

        val composeMain by creating {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.bundles.compose.multiplatform)
            }
        }

        androidMain {
            dependsOn(composeMain)
        }

        desktopMain.apply {
            dependsOn(composeMain)
        }

        wasmJsMain {
            dependsOn(composeMain)
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/shared"))