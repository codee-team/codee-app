package com.codee.app.plugins.data

public data class PluginContent<T>(
    public val compatibilitySettings: CompatibilitySettings,
    public val content: T
)