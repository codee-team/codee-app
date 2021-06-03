buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(androidBuildTools)
        classpath(kotlinGradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

