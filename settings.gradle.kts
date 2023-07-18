pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "seer"
include(":sample:androidApp")
//include(":sample:desktopApp")
include(":sample:shared")
include(":libs:core")
include(":libs:console")
