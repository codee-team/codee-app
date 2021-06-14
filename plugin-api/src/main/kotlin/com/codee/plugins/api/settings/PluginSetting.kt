package com.codee.plugins.api.settings

import com.codee.plugins.api.strings.LocalizedString


public typealias MutablePluginSettings = MutableList<PluginSetting<*>>
public typealias PluginSettings = List<PluginSetting<*>>


public class PluginSetting<T> (
    public val displayName: LocalizedString,
    public val key: String,
    public val type: PluginSettingType<T>,
    public val default: () -> T,
    public val onChange: (T) -> Unit
)
