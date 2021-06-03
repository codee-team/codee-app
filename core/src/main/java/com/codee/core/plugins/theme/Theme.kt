package com.codee.core.plugins.theme

sealed interface Theme {
    val primary: String
    val onPrimary: String
    val secondary: String
    val onSecondary: String
}