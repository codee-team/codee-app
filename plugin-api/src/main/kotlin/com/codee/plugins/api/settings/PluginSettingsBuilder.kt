package com.codee.plugins.api.settings

import com.codee.plugins.api.localization.string.LocalizedString

public interface PluginSettingsBuilder {
    /**
     * Adds switch setting into app.
     * @param title - localized title.
     * @param description - localized description.
     */
    public fun switch(
        title: LocalizedString,
        description: LocalizedString,
        block: SettingTriggerBuilder<Boolean>.() -> Unit
    )

    /**
     * Adds string input setting into app.
     * @param title - localized title.
     * @param description - localized description.
     */
    public fun string(
        title: LocalizedString,
        description: LocalizedString,
        block: SettingTriggerBuilder<String>.() -> Unit
    )

    /**
     * Adds int picker setting into app.
     * @param title - localized title.
     * @param description - localized description.
     */
    public fun int(
        title: LocalizedString,
        description: LocalizedString,
        block: SettingTriggerBuilder<Int>.() -> Unit
    )

    /**
     * Adds double picker setting into app.
     * @param title - localized title.
     * @param description - localized description.
     */
    public fun double(
        title: LocalizedString,
        description: LocalizedString,
        block: SettingTriggerBuilder<Double>.() -> Unit
    )
}