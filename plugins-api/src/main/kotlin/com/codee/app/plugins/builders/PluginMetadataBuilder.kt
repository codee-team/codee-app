package com.codee.app.plugins.builders

import com.codee.app.plugins.annotations.InternalOnly
import com.codee.app.plugins.data.CompatibilitySettings
import com.codee.app.plugins.data.PluginMetadata

public class PluginMetadataBuilder {
    /**
     * Plugin name. Should be specified.
     */
    public lateinit var name: String

    public var versionName: String = "1.0"

    public var versionCode: Int = 1

    public var compatibilitySettings: CompatibilitySettings =
        CompatibilitySettings(currentVersion = versionCode)

    public fun compatibilitySettings(block: CompatibilitySettings.() -> Unit) {
        compatibilitySettings.apply(block)
    }

}

@InternalOnly
public fun PluginMetadataBuilder.toPluginMetadata(): PluginMetadata {
    return PluginMetadata(name, versionName, versionCode, compatibilitySettings)
}