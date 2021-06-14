package com.codee.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.codee.core.strings.RuStrings
import com.codee.core.strings.Strings
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StringsComposable()
        }

        GlobalScope.launch {
            delay(timeMillis = 2000)
            Strings.value = RuStrings
        }
    }
}
