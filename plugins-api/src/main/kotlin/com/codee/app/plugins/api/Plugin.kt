package com.codee.app.plugins.api

import com.codee.app.plugins.api.manager.AppManager
import com.codee.app.plugins.api.manager.PluginApiManager
import com.codee.app.plugins.api.manager.PluginLocalizationManager
import com.codee.app.plugins.api.objects.PluginMetadata

public interface Plugin {
    /**
     * Sets metadata for plugin.
     * @param metadata - metadata.
     */
    public fun setMetadata(metadata: PluginMetadata)

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
}