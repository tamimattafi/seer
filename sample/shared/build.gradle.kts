plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("native.cocoapods")
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
        name = "shared"
        summary = "Shared module"
        homepage = "https://github.com/tamimattafi/seer"
        version = "0.0.1"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "shared"
            export(project(":libs:core"))
            export(project(":libs:console"))
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":libs:core"))
                api(project(":libs:console"))
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
                api(project(":libs:console"))
            }
        }
    }
}

android {
    namespace = "com.attafitamim.seer.sample"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
}