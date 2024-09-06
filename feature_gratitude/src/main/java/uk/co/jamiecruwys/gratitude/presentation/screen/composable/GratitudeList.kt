package uk.co.jamiecruwys.gratitude.presentation.screen.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeGroupDate
import uk.co.jamiecruwys.gratitude.presentation.screen.GratitudeViewModel
import uk.co.jamiecruwys.showcase.theme.getListColors

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GratitudeList(
    modifier: Modifier,
    groupedEntries: Map<String, List<GratitudeEntry>>,
    scrollState: GratitudeViewModel.ScrollState,
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(System.currentTimeMillis()) {
        when (scrollState) {
            GratitudeViewModel.ScrollState.Scroll -> {
                coroutineScope.launch {
                    listState.animateScrollToItem(0)
                }
            }
            GratitudeViewModel.ScrollState.Idle -> {} // No action
        }
    }

    val listColors = getListColors()
    val groupDate = GratitudeGroupDate()
    LazyColumn(modifier = modifier, state = listState, contentPadding = PaddingValues(bottom = 8.dp)) {
        var currentIndex = 0
        groupedEntries.entries.forEach { map ->
            val dateString = map.key
            val entries = map.value

            val date = groupDate.fromDateString(dateString)
            stickyHeader {
                GratitudeDateDivider(date = date, dateStringFallback = dateString)
            }
            items(entries) { entry ->
                val backgroundColor = getColorForIndex(currentIndex, listColors)
                GratitudeRow(
                    gratitudeEntry = entry,
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
