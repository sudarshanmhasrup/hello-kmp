plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.webWasm.group.get()
version = libs.versions.webWasm.version.get()

kotlin {
    wasmJs {
        browser()
        binaries.executable()
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/web-wasm"))