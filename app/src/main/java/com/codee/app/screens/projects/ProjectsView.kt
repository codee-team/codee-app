package com.codee.app.screens.projects

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.codee.app.core.appStrings
import com.codee.app.core.remember

@Preview
@Composable
fun ProjectsView() {
    val strings = appStrings.remember()
    Scaffold(topBar = { Toolbar(strings.projects) }) {

    }
}

@Composable
private fun Toolbar(title: String) = TopAppBar(
    title = { Text(text = title) }
)