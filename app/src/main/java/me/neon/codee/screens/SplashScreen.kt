package me.neon.codee.screens

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.neon.codee.resources.currentLocale

class SplashScreen : Screen() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Composable
fun SplashView() = Surface(Modifier.fillMaxSize()) {
    Text(text = currentLocale.value.languageCode)
}