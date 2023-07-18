plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android()
    ios()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    cocoapods {
        name = "console"
        summary = "Console logging module"
        homepage = "https://github.com/tamimattafi/seer"
        version = "0.0.1"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "console"
            export(project(":libs:core"))
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":libs:core"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosMain by getting {
            dependencies {
                api(project(":libs:core"))
            }
        }
    }
}

android {
    namespace = "com.attafitamim.seer.libs.console"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
}