package com.codee.app.screens.projects

import androidx.compose.foundation.Image
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ProjectsView() = Scaffold(
    topBar = { Toolbar(title = "Codee") },
    floatingActionButton = { FAB() }
) {

}

@Composable
private fun Toolbar(title: String) = TopAppBar(
    title = { Text(text = title) }
)

@Composable
private fun FAB() = FloatingActionButton(
    onClick = {

    }) {
    Image(
        imageVector = Icons.Outlined.Create,
        contentDescription = null
    )
}