package com.codee.plugins.api.localization.string

import com.codee.plugins.api.localization.LocalizableBuilder
import com.codee.plugins.api.localization.localizable
import kotlin.properties.ReadOnlyProperty

public fun localizableString(
    default: String, builder: LocalizableBuilder<String>.() -> Unit
): ReadOnlyProperty<Any?, LocalizableString> {
    val localizable = localizable(default, builder)
    return ReadOnlyProperty { _, _ ->
        return@ReadOnlyProperty LocalizableString(localizable)
    }
}

public class LocalizableStringBuilder : LocalizableBuilder<String>()