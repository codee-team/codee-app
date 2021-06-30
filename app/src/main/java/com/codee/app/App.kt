package com.codee.app

import android.app.Application
import com.codee.app.core.appContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}