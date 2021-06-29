package com.codee.app.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.codee.app.resouces.locale.strings.AppStrings

/**
 * Default localized codee strings.
 */
object CodeeStrings : AppStrings

/**
 * Codee localized strings.
 */
val appStrings = mutableStateOf<AppStrings>(CodeeStrings)

/**
 * Converts [MutableState] of [AppStrings] to rememberable state.
 */
@Composable
fun MutableState<AppStrings>.remember() =
    androidx.compose.runtime.remember { this }