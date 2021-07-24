package com.codee.app.core.plugins.container

import com.codee.app.core.plugins.Plugin
import com.codee.app.core.plugins.PluginOwned
import com.codee.app.plugins.api.container.ProjectsCategory
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.map
import com.codee.app.plugins.api.container.ProjectTemplatesContainer as IProjectTemplatesContainer

internal val registeredTemplates: MutableSharedFlow<PluginOwned<ProjectsCategory>> =
    MutableSharedFlow()

class ProjectTemplatesContainer(private val plugin: Plugin) : IProjectTemplatesContainer {
    override val categories: SharedFlow<ProjectsCategory> =
        registeredTemplates.map { it.value } as SharedFlow<ProjectsCategory>

    override fun <T : ProjectsCategory> register(instance: T) {
        registeredTemplates.tryEmit(PluginOwned(plugin, instance))
    }
}