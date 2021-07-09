import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

dependencies {
    implementation(resources)
    implementation(coroutines)
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.5"
}