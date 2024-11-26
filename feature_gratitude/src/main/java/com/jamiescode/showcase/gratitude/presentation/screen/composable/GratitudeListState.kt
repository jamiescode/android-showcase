package com.jamiescode.showcase.gratitude.presentation.screen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jamiescode.showcase.gratitude.R
import com.jamiescode.showcase.gratitude.presentation.screen.GratitudeViewModel
import com.jamiescode.showcase.quote.presentation.screen.quoteCard
import com.jamiescode.showcase.theme.gratitudeFont

@Composable
fun gratitudeListState(
    modifier: Modifier,
    state: GratitudeViewModel.State,
    scrollState: GratitudeViewModel.ScrollState,
    viewModel: GratitudeViewModel,
    showQuotes: Boolean,
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
            val entries = state.gratitudeEntries
            if (entries.isEmpty()) {
                emptyState(
                    modifier = modifier,
                    showQuotes = showQuotes,
                )
            } else {
                gratitudeList(
                    modifier = modifier,
                    groupedEntries = state.gratitudeEntries,
                    scrollState = scrollState,
                    viewModel = viewModel,
                )
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
    Text(
        text = text,
        fontFamily = gratitudeFont,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
    )
}

@Composable
private fun emptyState(
    modifier: Modifier,
    showQuotes: Boolean,
) {
    Box(modifier = modifier) {
        stateContentContainer(modifier = Modifier.fillMaxSize()) {
            stateText(
                text = stringResource(R.string.empty_message),
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            if (showQuotes) {
                quoteCard()
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
