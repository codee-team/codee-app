package com.codee.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.codee.app.resources.CodeeTheme
import com.codee.app.screens.main.MainView

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeeTheme {
                MainView(rememberNavController())
            }
        }
    }
}