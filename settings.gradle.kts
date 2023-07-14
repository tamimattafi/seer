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

rootProject.name = "Seer"
include(":core")
include(":sampleAndroid")
include(":core:domain")
include(":core:data")
include(":core:domain:model")
include(":core:domain:repository")
include(":core:domain:interaction")
