package com.jamiescode.showcase.gratitude.presentation.screen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jamiescode.showcase.gratitude.R
import com.jamiescode.showcase.gratitude.presentation.domain.model.GratitudeEntry
import com.jamiescode.showcase.theme.gratitudeFont

@Composable
fun gratitudeRow(
    gratitudeEntry: GratitudeEntry,
    backgroundColor: Color,
    onEditEntry: (GratitudeEntry) -> Unit,
) {
    Card(
        modifier =
            Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(containerColor = backgroundColor),
    ) {
        Row(
            modifier =
                Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = gratitudeEntry.entry,
                fontFamily = gratitudeFont,
                fontSize = 22.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f),
            )
            Spacer(modifier = Modifier.size(8.dp))
            IconButton(
                onClick = { onEditEntry(gratitudeEntry) },
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = stringResource(R.string.edit_entry),
                    tint = Color.Black,
                )
            }
        }
    }
}
