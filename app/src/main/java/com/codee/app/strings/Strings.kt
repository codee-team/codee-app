package com.codee.app.strings

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


object Strings : MutableState<IStrings> by mutableStateOf(DefaultStrings)
