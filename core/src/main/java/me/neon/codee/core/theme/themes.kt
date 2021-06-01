package me.neon.codee.core.theme

private val themesSource: MutableSet<AbstractTheme> = mutableSetOf(LightTheme(), DarkTheme())

/**
 * Consists of all loaded themes.
 * @return [Set] with [AbstractTheme].
 */
val themes: Set<AbstractTheme> get() = themesSource

/**
 * Registers new theme.
 * @param abstractTheme - implemented [AbstractTheme] with theme info.
 * @return [Boolean] is added or not.
 */
fun registerTheme(abstractTheme: AbstractTheme) =
    themesSource.add(abstractTheme)