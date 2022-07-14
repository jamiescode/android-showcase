package uk.co.jamiecruwys.showcase.presentation

sealed class Destinations(val route: String) {
    object Home : Destinations(Routes.HOME.value)
    object Dogs : Destinations(Routes.DOGS.value)
    object Cats : Destinations(Routes.CATS.value)
}
