package com.codee.app.plugins.api

import com.codee.app.plugins.api.container.AppContainer
import com.codee.app.plugins.api.container.PluginApiContainer
import com.codee.app.plugins.api.container.PluginLocalizationContainer
import com.codee.app.plugins.api.container.ProjectTemplatesContainer

public interface PluginScope {
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