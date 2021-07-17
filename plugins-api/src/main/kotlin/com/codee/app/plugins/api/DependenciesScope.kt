package com.codee.app.plugins.api

/**
 * Used in **dependencies.codee.kts** for specifying external dependencies.
 * Runs after **manifest.codee.kts** if everything is okay (for example,
 * compatibility settings are approved).
 */
public interface DependenciesScope {
    /**
     * Implements [coordinates] into **main.codee.kts** file (and in imported scripts).
     * @param coordinates - coordinates to artifact (jar, e.x: com.example:my-library:1.0).
     */
    public fun implementation(coordinates: String)
}