package uk.co.jamiecruwys.showcase.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import uk.co.jamiecruwys.showcase.ui.catsScreen
import uk.co.jamiecruwys.showcase.ui.dogsScreen
import uk.co.jamiecruwys.showcase.ui.homeScreen

fun NavGraphBuilder.createNavigationRoutes(navController: NavController) {
    composable(
        route = uk.co.jamiecruwys.navigation.Destinations.Home.route
    ) {
        homeScreen(navController)
    }
    composable(
        route = uk.co.jamiecruwys.navigation.Destinations.Dogs.route
    ) {
        dogsScreen()
    }
    composable(
        route = uk.co.jamiecruwys.navigation.Destinations.Cats.route
    ) {
        catsScreen()
    }
}