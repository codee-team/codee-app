package com.codee.app.core.plugins

import com.codee.app.core.plugins.container.AppContainer
import com.codee.app.core.plugins.container.PluginApiContainer
import com.codee.app.core.plugins.container.PluginLocalizationContainer
import com.codee.app.core.plugins.container.ProjectTemplatesContainer
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext
import com.codee.app.plugins.api.PluginScope as IPluginScope

class PluginScope(metadata: PluginMetadata) : IPluginScope {
    override val app: AppContainer = AppContainer
    override val apis: PluginApiContainer =
        PluginApiContainer(pluginWithMetadataOrNew(metadata, this))
    override val localizations: PluginLocalizationContainer =
        PluginLocalizationContainer(pluginWithMetadataOrNew(metadata, this))
    override val templates: ProjectTemplatesContainer =
        ProjectTemplatesContainer(pluginWithMetadataOrNew(metadata, this))
    override val coroutineContext: CoroutineContext = Dispatchers.Main
}