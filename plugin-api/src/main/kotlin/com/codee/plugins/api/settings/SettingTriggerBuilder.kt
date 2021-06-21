package com.codee.plugins.api.settings

import com.codee.plugins.api.annotations.PluginDSL

@PluginDSL
public interface SettingTriggerBuilder<T> {
    /**
     * Default value of setting.
     */
    public fun default(block: () -> T)

    /**
     * Invokes when value changed.
     */
    public fun changed(block: (T) -> Unit)
}

