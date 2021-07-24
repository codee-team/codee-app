package com.codee.app.plugins.api

/**
 * Used in **manifest.codee.kts** for specifying external dependencies.
 * Runs after declaring plugin info if everything is okay (for example,
 * compatibility settings are approved).
 */
public interface DependenciesScope {
    /**
     * Implements [coordinates] into **main.plugin.kts** file (and in imported scripts).
     * @param coordinates - coordinates to artifact (jar, e.x: com.example:my-library:1.0).
     */
    public fun implementation(coordinates: String, block: DependencyScope.() -> Unit)
}

public fun DependenciesScope.implementation(coordinates: String): Unit =
    implementation(coordinates) {
        repositories {
            maven("https://repo1.maven.org/maven2/")
            maven("https://maven.kotlingang.fun")
        }
    }

public fun DependenciesScope.implementation(coordinates: String, mavenRepository: String): Unit =
    implementation(coordinates) {
        repositories {
            maven(mavenRepository)
        }
    }

public interface DependencyScope {
    /**
     * Dependency repositories to search.
     */
    public fun repositories(block: DependencyRepositoriesScope.() -> Unit)
}

public interface DependencyRepositoriesScope {
    /**
     * Adds maven repository for dependency resolving.
     * @param coordinates - url to maven.
     */
    public fun maven(coordinates: String)
}