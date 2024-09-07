package com.jamiescode.showcase.presentation.compose

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.jamiescode.showcase.R
import com.jamiescode.showcase.theme.getIconColor
import com.jamiescode.showcase.theme.gratitudeFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customTopAppBar(
    onLaunchHome: () -> Unit,
    onLaunchSettings: () -> Unit,
    onLaunchSearch: () -> Unit,
) {
    CenterAlignedTopAppBar(
        scrollBehavior = pinnedScrollBehavior(),
        title = {
            Text(
                text = stringResource(id = R.string.app_bar_title),
                modifier = Modifier.clickable { onLaunchHome() },
                fontSize = 36.sp,
                fontFamily = gratitudeFont,
                textAlign = TextAlign.Center,
            )
        },
        actions = {
            IconButton(
                onClick = { onLaunchSearch() },
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = stringResource(R.string.menu_search),
                    tint = getIconColor(),
                )
            }
            IconButton(
                onClick = {
                    onLaunchSettings()
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = stringResource(R.string.menu_settings),
                    tint = getIconColor(),
                )
            }
        },
    )
}
