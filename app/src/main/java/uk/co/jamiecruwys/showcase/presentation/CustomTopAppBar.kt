package uk.co.jamiecruwys.showcase.presentation

import android.content.Intent
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import uk.co.jamiecruwys.showcase.R

@Composable
fun customTopAppBar() {
    val appName = stringResource(id = R.string.app_name)
    val context = LocalContext.current

    TopAppBar(
        title = {
            Text(text = appName)
        },
        actions = {
            overflowMenu {
                DropdownMenuItem(
                    onClick = {
                        val intent = Intent(context, OssLicensesMenuActivity::class.java)
                        startActivity(context, intent, null)
                    }
                ) {
                    Text(stringResource(id = R.string.menu_oss_title))
                }
            }
        }
    )
}
