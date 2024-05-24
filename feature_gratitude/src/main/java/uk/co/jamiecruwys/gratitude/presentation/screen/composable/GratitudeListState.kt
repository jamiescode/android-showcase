package uk.co.jamiecruwys.gratitude.presentation.screen.composable

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.jamiecruwys.gratitude.presentation.screen.GratitudeViewModel

@Composable
fun gratitudeListState(
    listModifier: Modifier,
    state: GratitudeViewModel.State,
) {
    when (state) {
        GratitudeViewModel.State.Initial -> {
            Text(text = "Initial state")
        }
        GratitudeViewModel.State.Loading -> {
            CircularProgressIndicator()
        }
        GratitudeViewModel.State.Error -> {
            Text(text = "Error loading gratitude entries")
        }
        is GratitudeViewModel.State.Loaded -> {
            gratitudeList(
                modifier = listModifier,
                gratitudeEntries = state.gratitudeEntries,
            )
        }
        GratitudeViewModel.State.Empty -> {
            Text(text = "Enter what you are grateful for in the text input at the bottom")
        }
    }
}
