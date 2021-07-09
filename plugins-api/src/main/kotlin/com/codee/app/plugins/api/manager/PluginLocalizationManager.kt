package com.codee.app.plugins.api.manager

import com.codee.app.plugins.api.PluginApi
import com.codee.app.plugins.api.PluginLocalization
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

public interface PluginLocalizationManager {
    /**
     * All registered plugins api.
     */
    public val apis: SharedFlow<PluginLocalization>

    /**
     * Registers API for external access (you can register multiple
     * versions (currentVersion cannot be the same)).
     * @param instance - instance of [T].
     * @return [Boolean] is registered or not (As for now, the error can only be in the same version).
     */
    public fun <T : PluginLocalization> register(instance: T): Boolean
}

/**
 * Gets first registered [T].
 * Not recommended to use in order to compatibility.
 */
@OptIn(DelicateCoroutinesApi::class)
public inline fun <reified T : PluginLocalization> SharedFlow<PluginApi>.firstWithType(
    crossinline handler: T.() -> Unit
) {
    GlobalScope.launch {
        handler(filterIsInstance<T>().first())
    }
}

/**
 * Gets first compatible for [version] with [T]. Prefer to get version that specified in [version],
 * but if there no such version, gets first that in range of support in api.
 * @param version - version of api.
 * @param handler - type handler.
 */
@OptIn(DelicateCoroutinesApi::class)
public inline fun <reified T : PluginLocalization> SharedFlow<PluginApi>.firstCompatibleWithType(
    version: Int, crossinline handler: T.() -> Unit
) {
    GlobalScope.launch {
        handler(filterIsInstance<T>().first {
            it.compatibilitySettings.currentVersion == version
                    || it.compatibilitySettings.minSupportedVersion >= version
                    && it.compatibilitySettings.maxSupportedVersion ?: version <= version
        })
    }
}

/**
 * Gets every registered [T] and returns it in [handler].
 */
@OptIn(DelicateCoroutinesApi::class)
public inline fun <reified T : PluginLocalization> SharedFlow<PluginApi>.onEachType(
    noinline handler: (T) -> Unit
) {
    GlobalScope.launch {
        filterIsInstance<T>().onEach(handler::invoke)
    }
}