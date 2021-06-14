package com.codee.plugins.api.settings

import com.codee.plugins.api.annotations.PluginDSL
import com.codee.plugins.api.strings.LocalizedString


@PluginDSL
public class PluginTriggerBuilder<T> {
    internal var default: (() -> T)? = null
    public fun default(block: () -> T) { default = block }

    internal var changed: (T) -> Unit = {}
    public fun changed(block: (T) -> Unit) { changed = block }
}

@PluginDSL
public open class PluginSettingsBuilder {
    protected var settings: MutablePluginSettings = mutableListOf()

    public fun switch (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<Boolean>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<Boolean>().apply(block)

        settings += PluginSetting (
            displayName,
            key,
            PluginSettingType.Inline.Switch,
            default = triggers.default ?: error("Please provide default value"),
            onChange = triggers.changed
        )
    }

    public fun string (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<String>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<String>().apply(block)

        settings += PluginSetting (
            displayName,
            key,
            PluginSettingType.Picker.String,
            default = triggers.default ?: error("Please provide default value"),
            onChange = triggers.changed
        )
    }

    public fun int (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<Int>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<Int>().apply(block)

        settings += PluginSetting (
            displayName,
            key,
            PluginSettingType.Picker.Int,
            default = triggers.default ?: error("Please provide default value"),
            onChange = triggers.changed
        )
    }

    public fun simpleInt (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<Int>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<Int>().apply(block)

        settings += PluginSetting (
            displayName,
            key,
            PluginSettingType.Picker.SimpleInt,
            default = triggers.default ?: error("Please provide default value"),
            onChange = triggers.changed
        )
    }

    public fun rgbColor (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<UInt>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<UInt>().apply(block)

        settings += PluginSetting (
            displayName,
            key,
            PluginSettingType.Picker.RGBColor,
            default = triggers.default ?: error("Please provide default value"),
            onChange = triggers.changed
        )
    }

    public fun rgbaColor (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<UInt>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<UInt>().apply(block)

        settings += PluginSetting (
            displayName,
            key,
            PluginSettingType.Picker.RGBAColor,
            default = triggers.default ?: error("Please provide default value"),
            onChange = triggers.changed
        )
    }

    public fun plainText (
        displayName: LocalizedString,
        block: PluginTriggerBuilder<String>.() -> Unit
    ) {
        val triggers = PluginTriggerBuilder<String>().apply(block)

        settings += PluginSetting (
            displayName,
            key = "__plain__",
            PluginSettingType.PlainText,
            default = triggers.default ?: error("Please provide default value"),
            onChange = triggers.changed
        )
    }
}
