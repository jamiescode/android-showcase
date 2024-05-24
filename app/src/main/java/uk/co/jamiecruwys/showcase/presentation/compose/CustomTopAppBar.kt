package uk.co.jamiecruwys.showcase.presentation.compose

import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import uk.co.jamiecruwys.showcase.R

@Composable
fun customTopAppBar(
    appName: String,
    onLicensesClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(text = appName)
        },
        actions = {
            overflowMenu {
                DropdownMenuItem(
                    onClick = { onLicensesClicked.invoke() },
                ) {
                    Text(stringResource(id = R.string.menu_oss_title))
                }
            }
        },
    )
}
