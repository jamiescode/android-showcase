package uk.co.jamiecruwys.navigation

sealed class Destinations(
    val route: String,
) {
    data object Dogs : Destinations(Routes.DOGS.value)

    data object Gratitude : Destinations(Routes.GRATITUDE.value)

    data object Settings : Destinations(Routes.SETTINGS.value)
}
