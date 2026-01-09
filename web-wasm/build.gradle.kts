import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalDistributionDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.webWasm.group.get()
version = libs.versions.webWasm.version.get()

kotlin {
    @OptIn(ExperimentalWasmDsl::class, ExperimentalDistributionDsl::class)
    wasmJs {
        browser {
            distribution {
                outputDirectory.set(file("$rootDir/.build/wasm-distribution"))
            }
        }
        binaries.executable()
    }

    sourceSets {
        wasmJsMain.dependencies {
            implementation(libs.bundles.compose.multiplatform)
            implementation(projects.shared)
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/web-wasm"))