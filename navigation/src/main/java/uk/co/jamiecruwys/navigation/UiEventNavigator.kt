package uk.co.jamiecruwys.navigation

import androidx.navigation.NavController
import uk.co.jamiecruwys.showcase.ui.UiNavigationEvent

class UiEventNavigator(private val navController: NavController) {
    fun launch(uiNavigationEvent: UiNavigationEvent) {
        val route = mapToRoute(uiNavigationEvent)
        navController.navigate(route)
    }

    private fun mapToRoute(uiNavigationEvent: UiNavigationEvent) =
        when (uiNavigationEvent) {
            UiNavigationEvent.HOME -> Destinations.Home.route
            UiNavigationEvent.DOG -> Destinations.Dogs.route
            UiNavigationEvent.CAT -> Destinations.Cats.route
        }
}
