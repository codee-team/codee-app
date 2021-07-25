package com.codee.plugins.loader

import com.codee.app.plugins.api.ManifestScope

interface ManifestScopeLoader<T> : Loader<T> {
    /**
     * Scope where plugin defines it's abilities, information, etc.
     */
    val scope: ManifestScope
}