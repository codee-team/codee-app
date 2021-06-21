package com.codee.plugins.api.localization.string

import com.codee.plugins.api.localization.Localizable

/**
 * Localizable strings.
 */
public class LocalizableString(default: String, values: Collection<LocalizedString>)
    : Localizable<String>(default, values) {
        public constructor(localizable: Localizable<String>)
                : this(localizable.default, localizable.variants.map(::LocalizedString))
    }