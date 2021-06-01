package me.neon.codee.core.locale

private val localesSource: MutableSet<AbstractLocale> = mutableSetOf(EnglishLocale)

/**
 * All locales that were registered.
 */
val locales: Set<AbstractLocale> get() = localesSource.toSet()

/**
 * Registers locale for app translation.
 * @param locale - localized strings.
 * @param overwrite - overwrites an existing translation if it already exists.
 * @return [Boolean] - true if successfully added, false if there
 * was some error (for example: locale for this languageCode
 * already registered or you're already registered this locale).
 */
fun registerLocale(locale: AbstractLocale, overwrite: Boolean = false): Boolean {
    if(locales.any { it.languageCode == locale.languageCode }) {
        if(overwrite)
            localesSource.removeAll { it.languageCode == locale.languageCode }
        else return false
    }
    return localesSource.add(locale)
}