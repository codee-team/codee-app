package com.codee.app.core

import android.content.Context
import kotlin.properties.Delegates

/**
 * Application context.
 * Initializes on application start.
 */
var appContext: Context by Delegates.notNull()
