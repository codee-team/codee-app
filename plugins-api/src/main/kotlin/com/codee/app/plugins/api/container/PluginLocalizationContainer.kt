package com.codee.app.plugins.api.container

import com.codee.app.plugins.api.PluginLocalization
import kotlinx.coroutines.flow.SharedFlow

public interface PluginLocalizationContainer {
    public val registered: SharedFlow<PluginLocalization>

    public fun <T : PluginLocalization> register(instance: T): Boolean
}