package com.codee.plugins.loader

import com.codee.app.plugins.api.PluginScope

interface PluginScopeLoader<T> : Loader<T> {
    /**
     * Scope where plugin defines it's logic and behaviour.
     */
    val scope: PluginScope
}