package com.jamiescode.showcase.navigation

sealed class Destinations(
    val route: String,
) {
    data object Gratitude : Destinations(Routes.GRATITUDE.value)

    data object Settings : Destinations(Routes.SETTINGS.value)

    data object UnderConstruction : Destinations(Routes.UNDER_CONSTRUCTION.value)

    data object Nowhere : Destinations("")
}
