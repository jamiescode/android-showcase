package uk.co.jamiecruwys.navigation

sealed class Destinations(val route: String) {
    data object Dogs : Destinations(Routes.DOGS.value)

    data object Gratitude : Destinations(Routes.GRATITUDE.value)
}
