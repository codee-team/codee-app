package com.codee.plugins.api

import com.codee.plugins.api.settings.PluginSettings
import com.codee.plugins.api.settings.PluginSettingsBuilder
import java.io.File


public interface PluginContext {
    /**
     * Dedicated plugin folder.
     * @return [File] with plugin's folder.
     */
    public val folder: File

    /**
     * Permissions controller.
     * @return [Permissions].
     */
    public val permissions: Permissions

    /**
     * Themes controller.
     * @return [Themes].
     */
    public val themes: Themes

    /**
     * Invoked when user goes to the settings to build plugin preferences list
     */
    public fun settings(block: PluginSettingsBuilder.() -> Unit)
}
