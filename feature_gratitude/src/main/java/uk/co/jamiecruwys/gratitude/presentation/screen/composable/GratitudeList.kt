package uk.co.jamiecruwys.gratitude.presentation.screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry

@Composable
fun gratitudeList(
    modifier: Modifier,
    gratitudeEntries: List<GratitudeEntry>,
) {
    Column(modifier = modifier) {
        gratitudeEntries.forEach { gratitudeEntry ->
            gratitudeRow(gratitudeEntry = gratitudeEntry)
        }
    }
}
