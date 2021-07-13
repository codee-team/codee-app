package com.codee.app.resources

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.codee.app.core.extensions.darkThemeColors
import com.codee.app.core.extensions.lightThemeColors
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Compose representation of codee theme.
 */
@Composable
fun CodeeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme)
        darkThemeColors.value
    else lightThemeColors.value
    rememberSystemUiController().apply {
        setSystemBarsColor(colors.primary, darkIcons = !darkTheme)
        setNavigationBarColor(colors.primary, darkIcons = !darkTheme)
    }
    MaterialTheme(
        colors = colors,
        content = content
    )
}