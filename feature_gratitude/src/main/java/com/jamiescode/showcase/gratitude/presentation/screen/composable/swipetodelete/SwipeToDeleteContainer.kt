package com.jamiescode.showcase.gratitude.presentation.screen.composable.swipetodelete

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jamiescode.showcase.gratitude.R

@Composable
fun <T> swipeToDeleteContainer(
    item: T,
    onRemoveItem: (item: T) -> Unit,
    content: @Composable RowScope.() -> Unit,
) {
    val isRemoved =
        remember {
            mutableStateOf(false)
        }
    val dismissState =
        rememberSwipeToDismissBoxState(
            confirmValueChange = {
                when (it) {
                    SwipeToDismissBoxValue.StartToEnd -> {
                        isRemoved.value = true
                        onRemoveItem(item)
                    }
                    SwipeToDismissBoxValue.EndToStart -> return@rememberSwipeToDismissBoxState false
                    SwipeToDismissBoxValue.Settled -> return@rememberSwipeToDismissBoxState false
                }
                return@rememberSwipeToDismissBoxState true
            },
            positionalThreshold = { it * .25f },
        )

    AnimatedVisibility(visible = !isRemoved.value) {
        SwipeToDismissBox(
            state = dismissState,
            backgroundContent = { swipeToDeleteBackground(dismissState) },
            enableDismissFromEndToStart = false,
            content = content,
        )
    }
}

@Composable
private fun swipeToDeleteBackground(dismissState: SwipeToDismissBoxState) {
    val color =
        when (dismissState.dismissDirection) {
            SwipeToDismissBoxValue.StartToEnd, SwipeToDismissBoxValue.EndToStart -> Color.Red
            SwipeToDismissBoxValue.Settled -> Color.Transparent
        }

    Row(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(vertical = 8.dp)
                .background(color),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            Icons.Default.Delete,
            contentDescription = stringResource(R.string.swipe_to_delete_background_content_desc),
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}
