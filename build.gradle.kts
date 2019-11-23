plugins {
    kotlin("multiplatform").version("1.3.60")
}

repositories {
    jcenter()
}

group = "com.h0tk3y.kotlin.mpp.optional"
version = "0.0.1"

kotlin {
    jvm()
    js()
    linuxX64()

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        val nonJvmOptional by creating {
            dependsOn(getByName("commonMain"))
        }
        configure(listOf(js(), linuxX64())) { // these are my two non-JVM targets
            compilations["main"].defaultSourceSet.dependsOn(nonJvmOptional)
        }
    }
}