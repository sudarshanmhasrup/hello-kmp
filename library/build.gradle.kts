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

    sourceSets {
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates(
        groupId = libs.versions.library.group.get(),
        artifactId = libs.versions.library.artifactId.get(),
        version = libs.versions.library.version.get()
    )

    pom {
        name.set("HelloKMP")
        description.set("A sample Kotlin Multiplatform library template that you can use to structure your next Kotlin Multiplatform library.")
        inceptionYear.set("2026")
        url.set("https://github.com/sudarshanmhasrup/hello-kmp")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("sudarshanmhasrup")
                name.set("Sudarshan")
                url.set("https://github.com/sudarshanmhasrup")
            }
        }
        scm {
            url.set("https://github.com/sudarshanmhasrup/hello-kmp")
            connection.set("scm:git:https://github.com/sudarshanmhasrup/hello-kmp.git")
            developerConnection.set("scm:git:ssh://git@github.com/sudarshanmhasrup/hello-kmp.git")
        }
    }
}