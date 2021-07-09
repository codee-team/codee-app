package com.codee.app.plugins.api

import com.codee.app.plugins.api.objects.CompatibilitySettings
import com.codee.app.resources.locale.Locale

public interface PluginLocalization {
    /**
     * Compatibility settings of plugin api.
     */
    public val compatibilitySettings: CompatibilitySettings

    /**
     * Localizations variants.
     */
    public val localizations: Set<Locale>
}