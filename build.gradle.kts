buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(androidBuildTools)
        classpath(kotlinGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

