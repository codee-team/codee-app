package com.codee.plugins.api

/**
 * Plugin metadata storage.
 */
public class PluginMetadata {

    /**
     * Name of plugin.
     * Should be specified once.
     */
    public var name: String? = null
        public set(value) {
            if(field == null)
                field = value
        }

    /**
     * Name of plugin.
     * Should be specified once.
     */
    public var version: String? = null
        public set(value) {
            if(field == null)
                field = value
        }

    /**
     * Name of plugin.
     * Should be specified once.
     */
    public var author: String? = null
        public set(value) {
            if(field == null)
                field = value
        }
}