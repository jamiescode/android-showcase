package uk.co.jamiecruwys.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import uk.co.jamiecruwys.navigation.Destinations
import uk.co.jamiecruwys.navigation.OpenSourceLicensesLauncher
import uk.co.jamiecruwys.showcase.ui.customTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainContent(
    appName: String,
    openSourceLicensesLauncher: OpenSourceLicensesLauncher = OpenSourceLicensesLauncher()
) {
    val navController = rememberNavController()
    val context = LocalContext.current
    MaterialTheme {
        Scaffold(
            topBar = {
                customTopAppBar(
                    appName = appName,
                    onLicensesClicked = {
                        openSourceLicensesLauncher.launch(context)
                    },
                )
            },
        ) {
            NavHost(
                navController = navController,
                startDestination = Destinations.Home.route,
                enterTransition = { fadeIn(animationSpec = tween(0)) },
                exitTransition = { fadeOut(animationSpec = tween(0)) },
                builder = { createNavigationRoutes(navController) },
            )
        }
    }
}
