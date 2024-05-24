package uk.co.jamiecruwys.showcase.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import uk.co.jamiecruwys.dog.presentation.screen.dogsScreen
import uk.co.jamiecruwys.gratitude.presentation.screen.gratitudeScreen
import uk.co.jamiecruwys.navigation.Destinations

fun NavGraphBuilder.createNavigationRoutes(navController: NavController) {
    composable(
        route = Destinations.Dogs.route,
    ) {
        dogsScreen()
    }
    composable(
        route = Destinations.Gratitude.route,
    ) {
        gratitudeScreen()
    }
}
