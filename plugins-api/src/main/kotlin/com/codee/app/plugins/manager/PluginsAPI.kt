package com.codee.app.plugins.manager

import com.codee.app.plugins.data.CompatibilitySettings
import com.codee.app.plugins.results.Either
import com.codee.app.plugins.results.WithTypeError

public interface PluginsAPI {
    /**
     * Registers API.
     * @param value - instance of [T].
     * @param version - version code of API.
     */
    public fun <T> register(value: T, compatibilitySettings: CompatibilitySettings)

    /**
     * Gets type by [T] & [version].
     * @param version - version of api.
     */
    public fun <T> withType(
        version: Int
    ): Either<T, WithTypeError>

    /**
     * Gets type by [T] & [version].
     * and returns it in [block] when it registered.
     * @param version - version of api.
     */
    public fun <T> whenTypeRegistered(
        version: Int,
        block: Either<T, WithTypeError>.() -> Unit
    )
}