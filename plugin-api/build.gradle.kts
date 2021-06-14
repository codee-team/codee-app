plugins {
    kotlin(Plugin.JVM)
}


group = "${ApplicationConfig.PACKAGE}.plugins.api"
version = ApplicationConfig.APPLICATION_VERSION_NAME

kotlin {
    explicitApi()
    sourceSets {
        all {
            languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
        }
    }
}