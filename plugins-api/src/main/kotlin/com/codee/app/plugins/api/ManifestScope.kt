package com.codee.app.plugins.api

import com.codee.app.resources.locale.strings.LocalizedString
import kotlinx.coroutines.CoroutineScope

/**
 * Plugin's metadata scope. It is place where plugins declare their names, versions,
 * compatibility settings, etc. Will be in separated file **manifest.codee.kts**.
 */
public interface ManifestScope {
    /**
     * Plugin localized name.
     */
    public var name: LocalizedString

    /**
     * Plugin's author name.
     */
    public var author: String

    /**
     * Plugin version name (e.x: 1.0.0).
     */
    public var versionName: String

    /**
     * Plugin version code (e.x: 3)
     */
    public var versionCode: Int

    /**
     * Codee settings scope.
     */
    public fun codee(block: CodeeScope.() -> Unit)

    /**
     * Plugin's external dependencies.
     */
    public fun dependencies(block: DependenciesScope.() -> Unit)
}

public interface CodeeScope {
    /**
     * Used to declare compatibility abilities of plugin.
     * @param block - anonymous object with [CodeeCompatibilitySettingsScope] inside.
     */
    public fun compatibility(block: CodeeCompatibilitySettingsScope.() -> Unit)
}

public interface CodeeCompatibilitySettingsScope {
    /**
     * Minimum supported codee version of plugin (if plugin incompatible with user's version,
     * user will be noticed automatically). It is optional value, but better to specify explicitly.
     */
    public var minCodeeVersion: Int?

    /**
     * Maximum supported codee version of plugin (optional parameter, in most of cases
     * you don't need to specify)
     */
    public var maxCodeeVersion: Int?
}