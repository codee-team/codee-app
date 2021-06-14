package com.codee.plugins.api

import com.codee.plugins.api.files.VirtualRootDirectory
import java.io.File

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
}