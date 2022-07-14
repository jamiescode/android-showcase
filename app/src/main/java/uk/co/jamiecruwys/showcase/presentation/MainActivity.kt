package uk.co.jamiecruwys.showcase.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.navigation.Destinations
import uk.co.jamiecruwys.showcase.R
import uk.co.jamiecruwys.showcase.ui.customTopAppBar

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val appName = stringResource(id = R.string.app_name)
            MaterialTheme {
                Scaffold(
                    topBar = {
                        customTopAppBar(
                            appName = appName,
                            onLicensesClicked = { showOpenSourceLicenses() }
                        )
                    }
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

    private fun showOpenSourceLicenses() {
        val intent = Intent(this, OssLicensesMenuActivity::class.java)
        ContextCompat.startActivity(this, intent, null)
    }
}
