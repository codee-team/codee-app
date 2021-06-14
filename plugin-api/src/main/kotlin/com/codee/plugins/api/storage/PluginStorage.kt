package com.codee.plugins.api.storage

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty

public interface PluginStorage {
    /**
     * Delegate for saving values.
     * @param defaultValue - default value.
     */
    public fun <T> value(defaultValue: T): ReadWriteProperty<Any?, T>

    /**
     * Observable list that saves automatically.
     */
    public fun <T> observableList(): ReadOnlyProperty<Any?, MutableList<T>>

    /**
     * Observable map that saves changes automatically.
     */
    public fun <K, V> observableMap(): ReadOnlyProperty<Any?, MutableMap<K, V>>

    /**
     * Observable set that saves changes automatically.
     */
    public fun <T> observableSet(): ReadOnlyProperty<Any?, MutableSet<T>>
}