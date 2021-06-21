package com.codee.plugins.api.localization.string

import com.codee.plugins.api.localization.Localized

public class LocalizedString(language: String, value: String)
    : Localized<String>(language, value) {
        public constructor(localized: Localized<String>): this(localized.language, localized.value)
    }