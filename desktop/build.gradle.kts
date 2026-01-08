import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.desktop.group.get()
version = libs.versions.desktop.version.get()

kotlin {
    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

    sourceSets {
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

compose.desktop {
    application {
        mainClass = libs.versions.desktop.mainClass.get()
        nativeDistributions {
            targetFormats = setOf(TargetFormat.Msi, TargetFormat.Dmg, TargetFormat.Deb)
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/desktop"))