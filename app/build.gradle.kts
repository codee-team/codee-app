plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.KOTLIN_ANDROID)
}

android {
    compileSdk = 30
    buildToolsVersion = ApplicationConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = "${ApplicationConfig.PACKAGE}.app"
        minSdk = ApplicationConfig.MIN_SDK_VERSION
        targetSdk = ApplicationConfig.TARGET_SDK_VERSION
        versionCode = ApplicationConfig.APPLICATION_VERSION_INT
        versionName = ApplicationConfig.APPLICATION_VERSION_NAME

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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.COMPOSE
    }
}

dependencies {
    implementation(androidKtCore)
    implementation(appCompat)
    implementation(material)
    implementation(composeUI)
    implementation(composeMaterial)
    implementation(composeUITooling)
    implementation(androidxLifecycle)
    implementation(activityCompose)
    implementation(coroutines)
    implementation(`app-core`)
    implementation(composeNav)
    implementation(resources)
    implementation(composeAccompanist)
    testImplementation(jUnit)
    androidTestImplementation(composeJUNIT)
}