package com.codee.plugins.api.strings

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


public open class LocalizedStrings {
    protected fun string (
        default: String, block: LocalizedStringBuilder.() -> Unit = {}
    ): LocalizedString = LocalizedStringBuilder().apply(block).toLocalizedString(default)
}

public class LocalizedStringBuilder internal constructor() {
    private var variants = mutableListOf<LocalizeVariant>()

    public fun value(value: String): CodeDelegate = CodeDelegate(value)

    internal fun toLocalizedString(default: String): LocalizedString =
        LocalizedString(default, variants)

    public inner class CodeDelegate internal constructor (
        private val value: String
    ) {
        public operator fun provideDelegate (
            thisRef: Any?, property: KProperty<*>
        ): ReadOnlyProperty<Any?, Unit> {
            variants += LocalizeVariant(property.name, value)
            return ReadOnlyProperty { _, _ ->  }
        }
    }
}

public class LocalizeVariant internal constructor (
    public val code: String,
    public val text: String
)

public class LocalizedString internal constructor (
    private val default: String,
    private val variants: List<LocalizeVariant>
) {
    public fun toString(code: String): String =
        variants.firstOrNull { it.code == code }?.text ?: default
}
