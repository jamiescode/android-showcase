package uk.co.jamiecruwys.showcase.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.createNavigationRoutes(navController: NavController) {
    composable(
        route = Destinations.Home.route
    ) {
        homeScreen(navController)
    }
    composable(
        route = Destinations.Dogs.route
    ) {
        dogsScreen()
    }
    composable(
        route = Destinations.Cats.route
    ) {
        catsScreen()
    }
}
