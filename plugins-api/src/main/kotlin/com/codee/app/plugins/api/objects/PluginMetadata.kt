package com.codee.app.plugins.api.objects

import kotlin.properties.Delegates

public data class PluginMetadata(
    public val name: String,
    public val author: String,
    public val version: Int
)

public class PluginMetadataBuilder {
    public lateinit var name: String
    public lateinit var author: String
    public var version: Int by Delegates.notNull()

    internal fun toPluginMetadata() = PluginMetadata(name, author, version)
}