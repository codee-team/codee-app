package com.codee.core.settings

import com.codee.plugins.api.settings.PluginSettingType
import com.codee.plugins.api.strings.LocalizedString

typealias PluginSettings = List<PluginSetting<*>>


class PluginSetting<T> (
    val displayName: LocalizedString,
    val key: String,
    val type: PluginSettingType<T>,
    val default: () -> T,
    val onChange: (T) -> Unit
)