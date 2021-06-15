package com.codee.app.strings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.codee.app.storage.internal.Preferences
import com.codee.plugins.api.strings.CoreStrings


val languageCode @Composable get() = remember { Preferences.languageCode }

val coreStringsState = mutableStateOf<CoreStrings>(value = DefaultStrings)
val coreStrings @Composable get() = remember { coreStringsState }
