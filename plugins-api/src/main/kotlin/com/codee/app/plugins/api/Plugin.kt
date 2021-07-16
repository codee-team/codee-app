package com.codee.app.plugins.api

import com.codee.app.plugins.api.container.AppContainer
import com.codee.app.plugins.api.container.PluginApiManager
import com.codee.app.plugins.api.container.PluginLocalizationContainer
import com.codee.app.plugins.api.container.ProjectsManager
import com.codee.app.plugins.api.objects.PluginMetadata
import com.codee.app.plugins.api.objects.PluginMetadataBuilder

public interface Plugin {
    /**
     * Sets metadata for plugin.
     * @param metadata - metadata.
     */
    public var metadata: PluginMetadata

    /**
     * Application manager.
     */
    public val app: AppContainer

    /**
     * Plugins api manager.
     */
    public val apiManager: PluginApiManager

    /**
     * Plugins localization manager.
     */
    public val localizationContainer: PluginLocalizationContainer

    /**
     * Projects manager.
     */
    public val projectsManager: ProjectsManager
}

public fun Plugin.metadata(block: PluginMetadataBuilder.() -> Unit) {
    metadata = PluginMetadataBuilder().apply(block).toPluginMetadata()
}