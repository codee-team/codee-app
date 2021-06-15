package com.codee.app.storage.internal

import `fun`.kotlingang.kds.KSharedDataStorage
import `fun`.kotlingang.kds.compose.mutable_state.mutableState


// Should be initialized in App.onCreate
lateinit var defaultSystemLanguageCode: String

object Preferences : KSharedDataStorage() {
    val languageCode by mutableState { defaultSystemLanguageCode }
}
