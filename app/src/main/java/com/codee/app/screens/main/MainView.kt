package com.codee.app.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codee.app.screens.projects.ProjectsView

@Composable
fun MainView(navController: NavHostController) = NavHost(
    navController = navController,
    startDestination = "projects",
    modifier = Modifier.fillMaxSize()
) {
    composable("projects") {
        ProjectsView()
    }
}