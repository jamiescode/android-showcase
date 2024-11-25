package com.jamiescode.showcase.gratitude.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow
import com.jamiescode.showcase.gratitude.presentation.screen.composable.gratitudeInput
import com.jamiescode.showcase.gratitude.presentation.screen.composable.gratitudeListState

@Composable
fun gratitudeScreen(showQuotes: Boolean = true, viewModel: GratitudeViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.loadEntries()
    }

    val state =
        viewModel.stateLiveData.asFlow().collectAsState(
            initial = GratitudeViewModel.State.Initial,
        )

    val scrollState = viewModel.scrollLiveData.asFlow().collectAsState(initial = GratitudeViewModel.ScrollState.Idle)

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        gratitudeListState(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
            state = state.value,
            scrollState = scrollState.value,
            viewModel = viewModel,
            showQuotes = showQuotes,
        )
        gratitudeInput(viewModel)
    }
}
