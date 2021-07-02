package com.codee.app.plugins.manager

import com.codee.app.plugins.exceptions.PluginTypeConflictException

public interface PluginsAPI {
    /**
     * Gets [T] from registered by plugins APIs and returns it in [block].
     * @throws NoSuchElementException if there no registered [T].
     */
    @Throws(NoSuchElementException::class)
    public fun <T> withType(block: T.() -> Unit)

    /**
     * @return [Boolean] is [T] registered or not.
     */
    public fun <T> isTypeRegistered(): Boolean

    /**
     * Registers [T] in plugins APIs.
     * @throws [PluginTypeConflictException] if there is conflict with
     * already registered [T].
     */
    @Throws(PluginTypeConflictException::class)
    public fun <T> register(instance: T)
}

/**
 * Gets [T] only if it registered. If not, just ignores [block].
 */
public fun <T> PluginsAPI.withTypeIfRegistered(block: T.() -> Unit): Unit =
    if(isTypeRegistered<T>())
        withType(block)
    else Unit