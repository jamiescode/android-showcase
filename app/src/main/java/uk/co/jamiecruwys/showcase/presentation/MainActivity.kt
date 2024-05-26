package uk.co.jamiecruwys.showcase.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.navigation.Destinations
import uk.co.jamiecruwys.showcase.presentation.compose.customTopAppBar

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                Scaffold(
                    topBar = {
                        Column {
                            customTopAppBar(
                                onLaunchSearch = {},
                                onLaunchSettings = {
                                    navController.navigate(Destinations.Settings.route)
                                },
                            )
                            HorizontalDivider(color = Color.Black, thickness = 1.dp)
                        }
                    },
                ) { contentPadding ->
                    Box(modifier = Modifier.padding(contentPadding)) {
                        NavHost(
                            navController = navController,
                            startDestination = Destinations.Gratitude.route,
                            enterTransition = { fadeIn(animationSpec = tween(0)) },
                            exitTransition = { fadeOut(animationSpec = tween(0)) },
                            builder = { createNavigationRoutes() },
                        )
                    }
                }
            }
        }
    }
}
