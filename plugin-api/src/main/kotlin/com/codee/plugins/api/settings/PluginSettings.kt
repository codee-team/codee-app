package com.codee.plugins.api.settings

public interface PluginSettings {
    /**
     * Adds option for plugin.
     * @param title - option title.
     * @param subtitle - option subtitle.
     */
    public fun addOption(
        title: String,
        subtitle: String,
        optionType: PluginOptionType = PluginOptionType.SIMPLE
    )
}