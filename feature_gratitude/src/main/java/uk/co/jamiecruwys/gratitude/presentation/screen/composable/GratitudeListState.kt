package uk.co.jamiecruwys.gratitude.presentation.screen.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.co.jamiecruwys.gratitude.presentation.screen.GratitudeViewModel
import uk.co.jamiecruwys.showcase.theme.gratitudeFont

@Composable
fun gratitudeListState(
    modifier: Modifier,
    state: GratitudeViewModel.State,
    scrollState: GratitudeViewModel.ScrollState,
) {
    when (state) {
        GratitudeViewModel.State.Initial -> {
            stateContentContainer(modifier) {
                stateText("Initial state")
            }
        }
        GratitudeViewModel.State.Loading -> {
            stateContentContainer(modifier = modifier) {
                CircularProgressIndicator()
            }
        }
        GratitudeViewModel.State.Error -> {
            stateContentContainer(modifier = modifier) {
                stateText("Error loading gratitude entries")
            }
        }
        is GratitudeViewModel.State.Loaded -> {
            gratitudeList(
                modifier = modifier,
                groupedEntries = state.gratitudeEntries,
                scrollState = scrollState,
            )
        }
        GratitudeViewModel.State.Empty -> {
            stateContentContainer(modifier = modifier) {
                stateText("Enter what you are grateful for in the text input at the bottom")
            }
        }
    }
}

@Composable
private fun stateContentContainer(
    modifier: Modifier,
    content: @Composable () -> Unit,
) {
    Box(modifier = modifier.padding(32.dp), contentAlignment = Alignment.Center) {
        content()
    }
}

@Composable
private fun stateText(text: String) {
    Text(text = text, fontFamily = gratitudeFont, fontSize = 24.sp)
}
