package com.codee.app.core

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object ContextDI {
    internal lateinit var context: Context
    fun init(context: Context) {
        this.context = context
    }
}