package uk.co.jamiecruwys.showcase.ui

import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

@Composable
fun overflowMenu(content: @Composable () -> Unit) {
    var showMenu by remember { mutableStateOf(false) }
    IconButton(
        onClick = {
            showMenu = !showMenu
        },
    ) {
        Icon(
            imageVector = Icons.Outlined.MoreVert,
            contentDescription = stringResource(R.string.more),
        )
    }
    DropdownMenu(
        expanded = showMenu,
        onDismissRequest = { showMenu = false },
    ) {
        content()
    }
}
