package com.codee.app.plugins.api

import com.codee.app.plugins.api.container.*
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
    public val apis: PluginApiContainer

    /**
     * Plugins localization manager.
     */
    public val localizations: PluginLocalizationContainer

    /**
     * Projects manager.
     */
    public val templates: ProjectTemplatesContainer
}

public fun Plugin.metadata(block: PluginMetadataBuilder.() -> Unit) {
    metadata = PluginMetadataBuilder().apply(block).toPluginMetadata()
}