package com.codee.app.plugins.api.objects

public data class CompatibilitySettings(
    public val minSupportedVersion: Int,
    public val maxSupportedVersion: Int?,
    public val currentVersion: Int
)