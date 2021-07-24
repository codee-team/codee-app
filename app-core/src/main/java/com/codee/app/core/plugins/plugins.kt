package com.codee.app.core.plugins

/**
 * All launched plugins
 */
internal val plugins: MutableList<Plugin> = mutableListOf()

internal fun pluginWithMetadata(metadata: PluginMetadata): Plugin? =
    plugins.firstOrNull { it.metadata == metadata }

internal fun pluginWithMetadataOrNew(metadata: PluginMetadata, scope: PluginScope): Plugin {
    return pluginWithMetadata(metadata) ?: run {
        val plugin = Plugin(metadata, scope)
        plugins.add(plugin)
        plugin
    }
}