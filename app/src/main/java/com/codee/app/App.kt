package com.codee.app

import android.app.Application
import com.codee.app.strings.defaultLanguageCode
import java.util.*


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        defaultLanguageCode = Locale.getDefault().language
    }
}