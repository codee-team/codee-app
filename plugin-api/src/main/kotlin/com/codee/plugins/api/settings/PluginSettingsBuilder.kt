package com.codee.plugins.api.settings

import com.codee.plugins.api.annotations.PluginDSL
import com.codee.plugins.api.strings.LocalizedString


@PluginDSL
public interface PluginTriggerBuilder<T> {
    public fun default(block: () -> T)
    public fun changed(block: (T) -> Unit)
}

@PluginDSL
public interface PluginSettingsBuilder {
    public fun switch (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<Boolean>.() -> Unit
    )

    public fun string (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<String>.() -> Unit
    )

    public fun int (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<Int>.() -> Unit
    )

    public fun simpleInt (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<Int>.() -> Unit
    )

    public fun rgbColor (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<UInt>.() -> Unit
    )

    public fun rgbaColor (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<UInt>.() -> Unit
    )

    public fun plainText (
        displayName: LocalizedString,
        key: String,
        block: PluginTriggerBuilder<String>.() -> Unit
    )
}
