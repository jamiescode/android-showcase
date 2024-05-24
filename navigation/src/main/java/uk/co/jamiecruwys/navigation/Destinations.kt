package uk.co.jamiecruwys.navigation

sealed class Destinations(val route: String) {
    data object Home : Destinations(Routes.HOME.value)

    data object Dogs : Destinations(Routes.DOGS.value)

    data object Cats : Destinations(Routes.CATS.value)
}
