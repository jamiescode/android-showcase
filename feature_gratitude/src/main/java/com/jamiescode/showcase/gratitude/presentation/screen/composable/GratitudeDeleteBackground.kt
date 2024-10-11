package com.jamiescode.showcase.gratitude.presentation.screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DismissBackground(dismissState: SwipeToDismissBoxState) {
    val color = when (dismissState.dismissDirection) {
        SwipeToDismissBoxValue.StartToEnd, SwipeToDismissBoxValue.EndToStart -> Color.Red
        SwipeToDismissBoxValue.Settled -> Color.Transparent
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
            .background(color),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            Icons.Default.Delete,
            contentDescription = "delete"
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}
