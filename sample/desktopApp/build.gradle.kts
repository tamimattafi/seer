import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        withJava()
    }

    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":sample:shared"))
            }
        }

        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }

        named("jvmTest") {
            dependencies {
                implementation("junit:junit:4.12")
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.attafitamim.seer.sample.desktop.Main_desktopKt"

        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi
            )

            packageName = "Seer Desktop Sample"
            packageVersion = "0.0.1"

            windows {
                menuGroup = "Seer Desktop Sample"
                upgradeUuid = "7abd45e8-22c0-11ec-9621-0242ac130002"
            }
        }
    }
}