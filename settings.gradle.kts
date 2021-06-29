dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
        maven("https://maven.kotlingang.fun")
    }
}
rootProject.name = "Codee"
include(":app")
include(":plugins-core")
include(":plugins-api")
include(":resources")
include(":app-core")
