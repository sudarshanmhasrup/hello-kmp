import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.webWasm.group.get()
version = libs.versions.webWasm.version.get()

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        wasmJsMain.dependencies {
            implementation(libs.bundles.compose.multiplatform)
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/web-wasm"))