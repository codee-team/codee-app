package com.codee.app.plugins

import com.codee.app.plugins.builders.PluginMetadataBuilder

public interface PluginContext {
    /**
     * Builds metadata for plugin (name, version, etc).
     */
    public fun metadata(block: PluginMetadataBuilder.() -> Unit)
    /**
     * Plugins controller.
     */
    public val plugins: Plugins
    /**
     * Theme controller.
     */
    public val themes: Themes
    /**
     * Notifies that main plugin stuff is loaded.
     * Required for [Plugins.afterEvaluation] if you after registering
     * some stuff in [plugins] do some work (not in async way).
     */
    public fun notifyEvaluated()
}