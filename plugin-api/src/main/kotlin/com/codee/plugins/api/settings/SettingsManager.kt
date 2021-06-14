package com.codee.plugins.api.settings


public interface SettingsManager {
    public operator fun set(key: String, value: Int)
    public operator fun set(key: String, value: String)
    public operator fun set(key: String, value: Boolean)
    public operator fun set(key: String, value: UInt)

    public operator fun get(key: String): SettingValue
}

public interface SettingValue {
    public val int: Int
    public val boolean: Boolean
    public val string: String
    public val uint: UInt
}
