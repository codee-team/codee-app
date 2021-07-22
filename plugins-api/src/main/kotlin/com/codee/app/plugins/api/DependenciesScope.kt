package com.codee.app.plugins.api

import kotlinx.coroutines.CoroutineScope

/**
 * Used in **dependencies.codee.kts** for specifying external dependencies.
 * Runs after **manifest.codee.kts** if everything is okay (for example,
 * compatibility settings are approved).
 *
 * Works on [kotlinx.coroutines.Dispatchers.IO] scope.
 */
public interface DependenciesScope : CoroutineScope {
    /**
     * Implements [coordinates] into **main.plugin.kts** file (and in imported scripts).
     * @param coordinates - coordinates to artifact (jar, e.x: com.example:my-library:1.0).
     */
    public suspend fun implementation(coordinates: String)
}