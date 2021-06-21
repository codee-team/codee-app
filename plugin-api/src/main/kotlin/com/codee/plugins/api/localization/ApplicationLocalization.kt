package com.codee.plugins.api.localization

import com.codee.plugins.api.localization.string.LocalizableString
import com.codee.plugins.api.localization.string.localizableString

/**
 * Application localization resources (now only strings).
 */
public abstract class ApplicationLocalization {
    public val projects: LocalizableString by localizableString("Projects") {
        "Проекты" to  Locale.RUSSIAN
        "Проєкти" to Locale.UKRAINIAN
    }
}