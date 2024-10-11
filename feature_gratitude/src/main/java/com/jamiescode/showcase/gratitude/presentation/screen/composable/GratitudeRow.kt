package com.jamiescode.showcase.gratitude.presentation.screen.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.jamiescode.showcase.gratitude.domain.model.GratitudeEntry

@Composable
fun gratitudeRow(
    gratitudeEntry: GratitudeEntry,
    backgroundColor: Color,
    onEditEntry: (GratitudeEntry) -> Unit,
    onRemoveEntry: (GratitudeEntry) -> Unit,
) {
    val isRemoved = remember {
        mutableStateOf(false)
    }
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            when (it) {
                SwipeToDismissBoxValue.StartToEnd -> {
                    isRemoved.value = true
                    onRemoveEntry(gratitudeEntry)
                }
                SwipeToDismissBoxValue.EndToStart -> return@rememberSwipeToDismissBoxState false
                SwipeToDismissBoxValue.Settled -> return@rememberSwipeToDismissBoxState false
            }
            return@rememberSwipeToDismissBoxState true
        },
        positionalThreshold = { it * .25f }
    )

    AnimatedVisibility(visible = !isRemoved.value) {
        SwipeToDismissBox(
            state = dismissState,
            backgroundContent = { DismissBackground(dismissState) },
            enableDismissFromEndToStart = false,
            content = {
                gratitudeRowCard(
                    gratitudeEntry = gratitudeEntry,
                    backgroundColor = backgroundColor,
                    onEditEntry = onEditEntry,
                )
            },
        )
    }
}
