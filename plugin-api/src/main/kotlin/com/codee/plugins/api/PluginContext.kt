package com.codee.plugins.api

import com.codee.plugins.api.files.VirtualRootDirectory
import com.codee.plugins.api.settings.PluginSettingsBuilder
import java.io.File

/**
 * The main class from which any plugin works.
 * Implicit receiver of script for each plugin.
 */
public interface PluginContext {
    /**
     * Dedicated plugin folder.
     * @return [File] with plugin's folder.
     */
    public val folder: VirtualRootDirectory

    /**
     * Themes controller.
     * @return [Themes].
     */
    public val themes: Themes

    /**
     * Invoked when user goes to the settings to build plugin preferences list
     */
    public fun settings(block: PluginSettingsBuilder.() -> Unit)

    /**
     * Invoked after plugin running. Should be specified first of all.
     */
    public fun metadata(block: PluginMetadata.() -> Unit)
}
