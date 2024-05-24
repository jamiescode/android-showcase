package uk.co.jamiecruwys.showcase.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.res.stringResource
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.navigation.mainContent
import uk.co.jamiecruwys.showcase.R
import uk.co.jamiecruwys.showcase.createNavigationRoutes

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainContent(
                appName = stringResource(id = R.string.app_name),
                createNavigationRoutes = { navGraphBuilder, uiEventNavigator ->
                    navGraphBuilder.createNavigationRoutes(uiEventNavigator)
                },
            )
        }
    }
}
