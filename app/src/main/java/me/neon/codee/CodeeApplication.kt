package me.neon.codee

import android.app.Application
import me.neon.codee.core.initializeApplication

/**
 * Base application class.
 */
class CodeeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeApplication(this)
    }
}