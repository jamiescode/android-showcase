package uk.co.jamiecruwys.showcase.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.navigation.Destinations
import uk.co.jamiecruwys.showcase.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val appName = stringResource(id = R.string.app_name)
            MaterialTheme {
                Scaffold(
                    topBar = { customTopAppBar(appName) }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Destinations.Home.route,
                        builder = { createNavigationRoutes(navController) }
                    )
                }
            }
        }
    }
}
