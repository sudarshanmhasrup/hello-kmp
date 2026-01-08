import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/desktop"))