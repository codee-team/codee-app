package com.codee.app.core.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal fun <T> oneTimeSet(): OneTimeSetDelegate<T> =
    OneTimeSetDelegate()

internal class OneTimeSetDelegate<T> : ReadWriteProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
            ?: throw NullPointerException("${property.name} is not initialized yet. Initialize it before get.")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (this.value == null)
            this.value = value
    }
}