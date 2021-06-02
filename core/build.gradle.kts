import org.gradle.util.GUtil.loadProperties

plugins {
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.KOTLIN_ANDROID)
    `maven-publish`
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdk = ApplicationConfig.MIN_SDK_VERSION
        targetSdk = ApplicationConfig.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

val deployConfigurationFile = rootProject.file("deploy.properties")

if(deployConfigurationFile.exists()) {
    val properties = loadProperties(deployConfigurationFile)
    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>("release") {
                    from(components["release"])

                    groupId = ApplicationConfig.PACKAGE
                    artifactId = "core"
                    version = Version.APPLICATION_VERSION_NAME
                }
            }
            repositories {
                maven {
                    url = uri("sftp://${properties.getProperty("host")}:22/${properties.getProperty("destination")}")

                    credentials {
                        username = properties.getProperty("user")
                        password = properties.getProperty("password")
                    }
                }
            }
        }
    }
}

dependencies {
    implementation(androidKtCore)
    implementation(appCompat)
    implementation(composeUI)
}

with(tasks) {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + "-Xallow-result-return-type"
        }
    }
}