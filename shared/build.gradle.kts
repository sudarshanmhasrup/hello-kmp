plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
}

group = libs.versions.shared.group.get()
version = libs.versions.shared.version.get()


// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/shared"))