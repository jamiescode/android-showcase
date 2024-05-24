package uk.co.jamiecruwys.gratitude.presentation.screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
import uk.co.jamiecruwys.showcase.theme.getListColors

@Composable
fun gratitudeList(
    modifier: Modifier,
    gratitudeEntries: List<GratitudeEntry>,
) {
    val listColors = getListColors()
    Column(modifier = modifier) {
        gratitudeEntries.forEachIndexed { index, gratitudeEntry ->
            val remainder = index % listColors.size
            val colorIndex = listColors.size - remainder - 1
            val backgroundColor = listColors[colorIndex]
            gratitudeRow(
                gratitudeEntry = gratitudeEntry,
                backgroundColor = backgroundColor,
            )
        }
    }
}
