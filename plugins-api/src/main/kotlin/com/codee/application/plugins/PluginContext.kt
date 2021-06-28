package com.codee.application.plugins

public interface PluginContext {
    /**
     * Builds metadata for plugin.
     */
    //public fun metadata(builder: Nothing.() -> Unit): Unit = TODO()

    /**
     * Theme controller.
     */
    public val themes: ThemeController
}