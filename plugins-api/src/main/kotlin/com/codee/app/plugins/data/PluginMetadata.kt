package com.codee.app.plugins.data

public class PluginMetadata(
    public val name: String,
    public val versionName: String = "1.0",
    public val versionCode: Int = 1,
    public val compatibilitySettings: CompatibilitySettings =
        CompatibilitySettings(currentVersion = versionCode)
)