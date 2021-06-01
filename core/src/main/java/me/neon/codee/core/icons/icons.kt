package me.neon.codee.core.icons

private val iconsSource: MutableSet<AbstractIcons> = mutableSetOf(MaterialIcons())

/**
 * @return [Set] of [AbstractIcons] with all icon packs that were loaded.
 */
val icons: Set<AbstractIcons> get() = iconsSource.toSet()

/**
 * Registers icon pack.
 * @param icons - set of icons.
 * @return [Boolean] is added or not.
 */
fun registerIcons(icons: AbstractIcons) = iconsSource.add(icons)