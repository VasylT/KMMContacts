rootProject.name = "ComposeMultiplatformApp"
include(":androidApp")
include(":shared")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        fun readVersion(name: String): String {
            return File("$rootDir/gradle/libs.versions.toml")
                .readLines()
                .first { it.contains(name) }
                .split("\"")[1]
        }

        val kotlinVersion = readVersion("kotlin")
        val agpVersion = readVersion("agp")
        val composeVersion = readVersion("compose")

        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)

        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)

        id("org.jetbrains.compose").version(composeVersion)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}