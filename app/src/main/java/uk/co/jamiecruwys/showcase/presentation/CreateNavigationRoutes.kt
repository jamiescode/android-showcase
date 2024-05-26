package uk.co.jamiecruwys.showcase.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import uk.co.jamiecruwys.gratitude.presentation.screen.gratitudeScreen
import uk.co.jamiecruwys.navigation.Destinations
import uk.co.jamiecruwys.showcase.settings.presentation.screen.settingsScreen

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
