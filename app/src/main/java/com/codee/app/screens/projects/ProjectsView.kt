package com.codee.app.screens.projects

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ProjectsView() {

}

@Composable
private fun Toolbar(title: String) = TopAppBar(
    title = { Text(text = title) }
)