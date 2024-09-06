package uk.co.jamiecruwys.showcase.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import uk.co.jamiecruwys.gratitude.presentation.screen.GratitudeScreen
import uk.co.jamiecruwys.navigation.Destinations
import uk.co.jamiecruwys.showcase.settings.presentation.screen.SettingsScreen

fun NavGraphBuilder.createNavigationRoutes() {
    composable(
        route = Destinations.Gratitude.route,
    ) {
        GratitudeScreen()
    }
    composable(
        route = Destinations.Settings.route,
    ) {
        SettingsScreen()
    }
}
