package com.codee.app.plugins.api

import com.codee.app.plugins.api.manager.AppManager
import com.codee.app.plugins.api.manager.PluginApiManager
import com.codee.app.plugins.api.manager.PluginLocalizationManager
import com.codee.app.plugins.api.manager.ProjectsManager
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
    public val app: AppManager

    /**
     * Plugins api manager.
     */
    public val apiManager: PluginApiManager

    /**
     * Plugins localization manager.
     */
    public val localizationManager: PluginLocalizationManager

    /**
     * Projects manager.
     */
    public val projectsManager: ProjectsManager
}

public fun Plugin.metadata(block: PluginMetadataBuilder.() -> Unit) {
    metadata = PluginMetadataBuilder().apply(block).toPluginMetadata()
}