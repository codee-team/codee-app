package com.codee.app.plugins.data

/**
 * Compatibility settings.
 * @param minVersion - minimum supported version of api.
 * @param maxVersion - max supported version of api.
 * @param currentVersion - current version of api.
 */
public class CompatibilitySettings(
    public var minVersion: Int? = null,
    public var maxVersion: Int? = null,
    public var currentVersion: Int
)