package com.codee.app.core.plugins.container

import com.codee.app.core.plugins.Plugin
import com.codee.app.core.plugins.PluginOwned
import com.codee.app.plugins.api.PluginLocalization
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.map
import com.codee.app.plugins.api.container.PluginLocalizationContainer as IPluginLocalizationContainer

internal val registeredLocalizations: MutableSharedFlow<PluginOwned<PluginLocalization>> = MutableSharedFlow()

class PluginLocalizationContainer(private val plugin: Plugin) : IPluginLocalizationContainer {
    override val localizations: SharedFlow<PluginLocalization> =
        registeredLocalizations.map { it.value } as SharedFlow<PluginLocalization>

    override fun <T : PluginLocalization> register(instance: T): Boolean {
        return registeredLocalizations.tryEmit(PluginOwned(plugin, instance))
    }

}