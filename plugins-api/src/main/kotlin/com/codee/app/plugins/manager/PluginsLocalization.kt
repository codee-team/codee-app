package com.codee.app.plugins.manager

import com.codee.app.plugins.data.CompatibilitySettings
import com.codee.app.plugins.data.PluginContent
import com.codee.app.plugins.results.Either
import com.codee.app.plugins.results.WithTypeError

public interface PluginsLocalization {
    /**
     * Registers API.
     * @param value - instance of [T].
     * @param compatibilitySettings - compatibility settings.
     */
    public fun <T> register(value: T, compatibilitySettings: CompatibilitySettings)

    /**
     * Gets type by [T] & [version].
     * @param version - version of api.
     */
    public fun <T> withType(
        version: Int
    ): Either<PluginContent<T>, WithTypeError>

    /**
     * Gets type by [T] & [version].
     * and returns it in [block] when it registered.
     * @param version - version of api.
     */
    public fun <T> whenTypeRegistered(
        version: Int,
        block: Either<PluginContent<T>, WithTypeError>.() -> Unit
    )
}
