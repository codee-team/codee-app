package me.neon.codee.core.theme

private val themesSource: MutableSet<AbstractTheme> = mutableSetOf(LightTheme(), DarkTheme())

/**
 * Consists of all loaded themes.
 * @return [Set] with [AbstractTheme].
 */
val themes: Set<AbstractTheme> get() = themesSource.toSet()

/**
 * Registers new theme.
 * @param theme - implemented [AbstractTheme] with theme info.
 * @return [Boolean] is added or not.
 */
fun registerTheme(theme: AbstractTheme) =
    themesSource.add(theme)