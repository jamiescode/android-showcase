package uk.co.jamiecruwys.showcase.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                Scaffold(
                    topBar = { customTopAppBar() }
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
