package com.codee.app.plugins.api.container

import com.codee.app.plugins.api.PluginLocalization
import kotlinx.coroutines.flow.SharedFlow

public interface PluginLocalizationContainer {
    /**
     * All registered plugins api.
     */
    public val localizations: SharedFlow<PluginLocalization>

    /**
     * Registers API for external access (you can register multiple
     * versions (currentVersion cannot be the same)).
     * @param instance - instance of [T].
     * @return [Boolean] is registered or not (As for now, the error can only be in the same version).
     */
    public fun <T : PluginLocalization> register(instance: T): Boolean
}