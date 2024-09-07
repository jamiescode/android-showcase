package com.jamiescode.showcase.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jamiescode.showcase.gratitude.presentation.screen.gratitudeScreen
import com.jamiescode.showcase.navigation.Destinations
import com.jamiescode.showcase.settings.presentation.screen.settingsScreen

fun NavGraphBuilder.createNavigationRoutes() {
    composable(
        route = Destinations.Gratitude.route,
    ) {
        gratitudeScreen()
    }
    composable(
        route = Destinations.Settings.route,
    ) {
        settingsScreen()
    }
}
