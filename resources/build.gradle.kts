plugins {
    kotlin(Plugin.JVM)
}


group = "${ApplicationConfig.PACKAGE}.app.resources"
version = ApplicationConfig.APPLICATION_VERSION_NAME

kotlin {
    explicitApi()
    sourceSets {
        all {
            languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
        }
    }
}