package uk.co.jamiecruwys.gratitude.presentation.screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeGroupDate
import uk.co.jamiecruwys.showcase.theme.getListColors

@Composable
fun gratitudeList(
    modifier: Modifier,
    gratitudeEntries: Map<String, List<GratitudeEntry>>,
) {
    val listColors = getListColors()
    val groupDate = GratitudeGroupDate()
    Column(modifier = modifier) {
        var currentIndex = 0
        gratitudeEntries.keys.forEach { dateString ->
            val date = groupDate.fromDateString(dateString)
            gratitudeDateDivider(date)
            gratitudeEntries[dateString]?.forEach { gratitudeEntry ->
                val backgroundColor = getColorForIndex(currentIndex, listColors)
                gratitudeRow(
                    gratitudeEntry = gratitudeEntry,
                    backgroundColor = backgroundColor,
                    onEditEntry = {},
                )
                currentIndex++
            }
        }
    }
}

fun getColorForIndex(
    index: Int,
    listColors: List<Color>,
): Color {
    val remainder = index % listColors.size
    val colorIndex = listColors.size - remainder - 1
    return listColors[colorIndex]
}
