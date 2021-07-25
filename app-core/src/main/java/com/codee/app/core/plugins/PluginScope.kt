package com.codee.app.core.plugins

import com.codee.app.core.ContextDI
import com.codee.app.core.internal.toMD5
import com.codee.app.core.plugins.container.AppContainer
import com.codee.app.core.plugins.container.PluginApiContainer
import com.codee.app.core.plugins.container.PluginLocalizationContainer
import com.codee.app.core.plugins.container.ProjectTemplatesContainer
import com.codee.app.core.plugins.files.RootDirectoryStorageElement
import com.codee.app.plugins.api.files.DirectoryStorageElement
import kotlinx.coroutines.Dispatchers
import java.io.File
import kotlin.coroutines.CoroutineContext
import com.codee.app.plugins.api.PluginScope as IPluginScope

class PluginScope(private val metadata: PluginMetadata) : IPluginScope {
    override val app: AppContainer = AppContainer
    override val apis: PluginApiContainer =
        PluginApiContainer(pluginWithMetadataOrNew(metadata, this))
    override val localizations: PluginLocalizationContainer =
        PluginLocalizationContainer(pluginWithMetadataOrNew(metadata, this))
    override val templates: ProjectTemplatesContainer =
        ProjectTemplatesContainer(pluginWithMetadataOrNew(metadata, this))
    override val workingDir: DirectoryStorageElement.RootDirectoryStorageElement
        get() = RootDirectoryStorageElement(
            File(
                ContextDI.context.filesDir,
                "plugins/storage/${(metadata.name + metadata.author).toMD5()}"
            )
        )
    override val coroutineContext: CoroutineContext = Dispatchers.Main
}