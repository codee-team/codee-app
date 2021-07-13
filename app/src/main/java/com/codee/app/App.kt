package com.codee.app

import android.app.Application
import com.codee.app.core.ContextDI

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ContextDI.init(this)
    }
}