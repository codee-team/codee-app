package com.codee.app.plugins.api.container

import com.codee.app.plugins.api.PluginApi
import com.codee.app.plugins.api.PluginLocalization
import kotlinx.coroutines.flow.SharedFlow

public interface PluginLocalizationContainer {
    /**
     * All registered plugins api.
     */
    public val registered: SharedFlow<PluginLocalization>

    /**
     * Registers API for external access (you can register multiple
     * versions (currentVersion cannot be the same)).
     * @param instance - instance of [T].
     * @return [Boolean] is registered or not (As for now, the error can only be in the same version).
     */
    public fun <T : PluginLocalization> register(instance: T): Boolean
}

public inline fun <reified T : PluginApi> PluginLocalizationContainer.firstWithType(
    crossinline handler: T.() -> Unit
) {
    return registered.firstWithType(handler)
}

public inline fun <reified T : PluginApi> PluginLocalizationContainer.firstCompatibleWithType(
    version: Int, crossinline handler: T.() -> Unit
): Unit = registered.firstCompatibleWithType(version, handler)