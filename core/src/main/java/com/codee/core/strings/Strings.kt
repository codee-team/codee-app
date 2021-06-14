package com.codee.core.strings

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.codee.plugins.api.strings.IStrings


object Strings : MutableState<IStrings> by mutableStateOf(
    DefaultStrings
)
