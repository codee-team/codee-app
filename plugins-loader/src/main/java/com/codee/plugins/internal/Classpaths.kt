package com.codee.plugins.internal

import java.io.File
import kotlin.reflect.KClass
import kotlin.script.experimental.jvm.util.classpathFromClass

internal fun classpathFrom(vararg classpath: KClass<*>): Collection<File> {
    return classpath.mapNotNull { classpathFromClass(it) }.flatten()
}