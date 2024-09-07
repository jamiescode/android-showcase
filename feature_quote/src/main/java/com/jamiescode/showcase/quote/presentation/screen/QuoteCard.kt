package com.jamiescode.showcase.quote.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow

@Composable
fun quoteCard(viewModel: QuoteViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.loadQuotes()
    }

    val state =
        viewModel.stateLiveData.asFlow().collectAsState(
            initial = QuoteViewModel.State.Initial,
        )
    when (val value = state.value) {
        QuoteViewModel.State.Initial -> {
            // Nothing
        }
        QuoteViewModel.State.Loading -> {
            quoteLoading()
        }
        QuoteViewModel.State.Error -> {
            quoteError()
        }
        is QuoteViewModel.State.Success -> {
            quoteSuccess(value.quote)
        }
    }
}
