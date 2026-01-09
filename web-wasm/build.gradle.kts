plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

group = libs.versions.webWasm.group.get()
version = libs.versions.webWasm.version.get()

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/web-wasm"))