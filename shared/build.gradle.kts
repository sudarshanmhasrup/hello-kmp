plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

group = libs.versions.shared.group.get()
version = libs.versions.shared.version.get()

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/shared"))