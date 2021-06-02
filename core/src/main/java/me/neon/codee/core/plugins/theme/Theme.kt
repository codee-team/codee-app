package me.neon.codee.core.plugins.theme

sealed interface Theme {
    val primary: UInt
    val onPrimary: UInt
    val secondary: UInt
    val onSecondary: UInt
}