package com.codee.app.plugins.api.container

import com.codee.app.plugins.api.PluginApi
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

public interface PluginApiContainer {
    /**
     * All registered plugins api.
     */
    public val all: SharedFlow<PluginApi>

    /**
     * Registers API for external access (you can register multiple
     * versions (currentVersion cannot be the same)).
     * @param instance - instance of [T].
     * @return [Boolean] is registered or not (As for now, the error can only be in the same version).
     */
    public fun <T : PluginApi> register(instance: T): Boolean
}

public inline fun <reified T : PluginApi> PluginApiContainer.firstWithType(
    crossinline handler: T.() -> Unit
) {
    return all.firstWithType(handler)
}

public inline fun <reified T : PluginApi> PluginApiContainer.firstCompatibleWithType(
    version: Int, crossinline handler: T.() -> Unit
): Unit = all.firstCompatibleWithType(version, handler)

/**
 * Gets first registered [T].
 * Not recommended to use in order to compatibility.
 */
@OptIn(DelicateCoroutinesApi::class)
public inline fun <reified T : PluginApi> SharedFlow<PluginApi>.firstWithType(
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
public inline fun <reified T : PluginApi> SharedFlow<PluginApi>.firstCompatibleWithType(
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
public inline fun <reified T : PluginApi> SharedFlow<PluginApi>.onEachType(
    noinline handler: (T) -> Unit
) {
    GlobalScope.launch {
        filterIsInstance<T>().onEach(handler::invoke)
    }
}