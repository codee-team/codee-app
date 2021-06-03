package com.codee.core.plugins

interface Plugin {
    /**
     * Name of plugin
     */
    val name: String

    /**
     * Author's name of plugin.
     */
    val author: String

    /**
     * Version of plugin.
     */
    val version: String

    /**
     * Unique plugin identifier. Should be static
     * and should not change regardless of version or name change.
     */
    val uuid: String

    /**
     * List of UUIDs of plugins that it depends on.
     */
    val dependsOn: List<String>
}