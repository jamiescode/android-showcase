package uk.co.jamiecruwys.showcase

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import uk.co.jamiecruwys.cat.presentation.screen.catsScreen
import uk.co.jamiecruwys.dog.presentation.screen.dogsScreen
import uk.co.jamiecruwys.home.presentation.screen.homeScreen
import uk.co.jamiecruwys.navigation.Destinations
import uk.co.jamiecruwys.navigation.UiEventNavigator

fun NavGraphBuilder.createNavigationRoutes(uiEventNavigator: UiEventNavigator) {
    composable(
        route = Destinations.Home.route,
    ) {
        homeScreen(
            sendUiNavigationEvent = { uiEventNavigator.launch(it) },
        )
    }
    composable(
        route = Destinations.Dogs.route,
    ) {
        dogsScreen()
    }
    composable(
        route = Destinations.Cats.route,
    ) {
        catsScreen()
    }
}
