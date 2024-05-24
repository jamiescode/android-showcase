package uk.co.jamiecruwys.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import uk.co.jamiecruwys.showcase.ui.screen.catsScreen
import uk.co.jamiecruwys.showcase.ui.screen.dogsScreen
import uk.co.jamiecruwys.showcase.ui.screen.homeScreen

fun NavGraphBuilder.createNavigationRoutes(uiEventNavigator: UiEventNavigator) {
    composable(
        route = Destinations.Home.route,
    ) {
        homeScreen(
            sendUiNavigationEvent = { uiEventNavigator.launch(it) }
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
