package com.codee.plugins.api

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
}