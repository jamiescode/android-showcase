package uk.co.jamiecruwys.gratitude.presentation.screen.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.co.jamiecruwys.gratitude.R
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
            // Nothing to show
        }
        GratitudeViewModel.State.Loading -> {
            stateContentContainer(modifier = modifier) {
                CircularProgressIndicator()
            }
        }
        GratitudeViewModel.State.Error -> {
            stateContentContainer(modifier = modifier) {
                stateText(stringResource(R.string.error_message))
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
                stateText(stringResource(R.string.empty_message))
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
