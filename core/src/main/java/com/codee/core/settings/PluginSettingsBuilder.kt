package com.codee.core.settings

import com.codee.plugins.api.settings.PluginSettingsBuilder
import com.codee.plugins.api.settings.PluginTriggerBuilder
import com.codee.plugins.api.strings.LocalizedString

class PluginTriggerBuilder<T> : PluginTriggerBuilder<T> {
    var default: (() -> T)? = null
    override fun default(block: () -> T) {
        default = block
    }

    var changed: (T) -> Unit = { }
    override fun changed(block: (T) -> Unit) {
        changed = block
    }
}

class PluginSettingsBuilder : PluginSettingsBuilder {
    private val mutableSettings = mutableListOf<PluginSetting<*>>()
    val settings: PluginSettings = mutableSettings

    override fun switch (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<Boolean>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<Boolean>().apply(block)

        mutableSettings += PluginSetting (
            displayName = displayName,
            key = key,
            type = PluginSettingType.Inline.Switch,
            default = triggers.default ?: error("You should specify default value for the setting"),
            onChange = triggers.changed
        )
    }

    override fun string (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<String>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<String>().apply(block)

        mutableSettings += PluginSetting (
            displayName = displayName,
            key = key,
            type = PluginSettingType.Picker.String,
            default = triggers.default ?: error("You should specify default value for the setting"),
            onChange = triggers.changed
        )
    }

    override fun int (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<Int>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<Int>().apply(block)

        mutableSettings += PluginSetting (
            displayName = displayName,
            key = key,
            type = PluginSettingType.Picker.Int,
            default = triggers.default ?: error("You should specify default value for the setting"),
            onChange = triggers.changed
        )
    }

    override fun simpleInt (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<Int>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<Int>().apply(block)

        mutableSettings += PluginSetting (
            displayName = displayName,
            key = key,
            type = PluginSettingType.Picker.SimpleInt,
            default = triggers.default ?: error("You should specify default value for the setting"),
            onChange = triggers.changed
        )
    }

    override fun rgbColor (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<UInt>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<UInt>().apply(block)

        mutableSettings += PluginSetting (
            displayName = displayName,
            key = key,
            type = PluginSettingType.Picker.RGBColor,
            default = triggers.default ?: error("You should specify default value for the setting"),
            onChange = triggers.changed
        )
    }

    override fun rgbaColor (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<UInt>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<UInt>().apply(block)

        mutableSettings += PluginSetting (
            displayName = displayName,
            key = key,
            type = PluginSettingType.Picker.RGBAColor,
            default = triggers.default ?: error("You should specify default value for the setting"),
            onChange = triggers.changed
        )
    }

    override fun plainText (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<String>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<String>().apply(block)

        mutableSettings += PluginSetting (
            displayName = displayName,
            key = key,
            type = PluginSettingType.PlainText,
            default = triggers.default ?: error("You should specify default value for the setting"),
            onChange = triggers.changed
        )
    }

}
