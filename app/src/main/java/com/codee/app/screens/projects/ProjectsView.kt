package com.codee.app.screens.projects

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codee.R
import com.codee.app.core.extensions.localize
import com.codee.app.resources.locale.strings.AppStrings
import com.codee.app.resources.locale.strings.CodeeStrings
import com.google.android.material.color.MaterialColors

@Composable
fun ProjectsView() = Scaffold(
    topBar = { Toolbar() },
    floatingActionButton = { FAB() }
) {
    LazyColumn {
        items(listOf(1, 2, 3)) {
            ProjectItem(name = "Some project")
        }
    }
}

@Composable
private fun Toolbar() = TopAppBar(
    title = { Text(text = CodeeStrings.projects.localize()) }
)

@Composable
private fun FAB() = FloatingActionButton(
    onClick = {

    }) {
    Image(
        imageVector = Icons.Outlined.Add,
        contentDescription = null
    )
}

@Composable
private fun ProjectItem(name: String) = Row(
    modifier = Modifier
        .selectable(selected = false) {

        },
    verticalAlignment = Alignment.CenterVertically
) {
    Image(
        painter = painterResource(id = R.mipmap.ic_launcher),
        modifier = Modifier.size(60.dp).padding(12.dp),
        contentDescription = "test"
    )
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = name, fontSize = 18.sp)
        Text(
            modifier = Modifier.alpha(0.8F),
            text = "/storage/emulated/0/data/somewhere",
            fontSize = 12.sp
        )
    }
}