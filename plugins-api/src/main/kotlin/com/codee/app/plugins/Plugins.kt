package com.codee.app.plugins

import com.codee.app.plugins.manager.PluginsAPI
import com.codee.app.plugins.manager.PluginsLocalization

/**
 * Plugins manager (API, resources, etc).
 */
public interface Plugins {
    /**
     * @return [PluginsAPI] to access plugins API.
     */
    public val api: PluginsAPI
    /**
     * @return [PluginsLocalization] with manager to access
     * plugins localization (to add localization variants, etc).
     */
    public val localization: PluginsLocalization

    /**
     * Invokes when all plugins evaluated.
     */
    public fun afterEvaluation(block: () -> Unit)
}