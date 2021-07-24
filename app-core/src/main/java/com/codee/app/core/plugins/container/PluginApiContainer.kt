package com.codee.app.core.plugins.container

import com.codee.app.core.plugins.Plugin
import com.codee.app.core.plugins.PluginOwned
import com.codee.app.plugins.api.PluginApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.map
import com.codee.app.plugins.api.container.PluginApiContainer as IPluginApiContainer

internal val registeredApis: MutableSharedFlow<PluginOwned<PluginApi>> = MutableSharedFlow()

class PluginApiContainer(private val plugin: Plugin) : IPluginApiContainer {
    override val all: SharedFlow<PluginApi> = registeredApis.map { it.value } as SharedFlow<PluginApi>

    override fun <T : PluginApi> register(instance: T): Boolean {
        return registeredApis.tryEmit(PluginOwned(plugin, instance))
    }
}