package uk.co.jamiecruwys.showcase.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.navigation.Destinations
import uk.co.jamiecruwys.navigation.launchOpenSourceLicenses
import uk.co.jamiecruwys.showcase.R
import uk.co.jamiecruwys.showcase.presentation.compose.customTopAppBar

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current
            MaterialTheme {
                Scaffold(
                    topBar = {
                        customTopAppBar(
                            appName = stringResource(id = R.string.app_name),
                            onLicensesClicked = { context.launchOpenSourceLicenses() },
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
    }
}
