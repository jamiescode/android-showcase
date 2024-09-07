package com.jamiescode.showcase.dog.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.jamiescode.showcase.dog.R
import timber.log.Timber

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun dogImageState(state: DogViewModel.State) {
    @Suppress("MagicNumber")
    val maxHeightFraction = 0.5f
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(maxHeightFraction),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (state) {
            is DogViewModel.State.Initial -> {
                // Show nothing
            }
            is DogViewModel.State.Error -> {
                dogImageError(message = stringResource(R.string.dog_image_error_message))
            }
            is DogViewModel.State.ImageAvailable -> {
                Timber.d("Image url: ${state.imageUrl}")
                GlideImage(
                    model = state.imageUrl,
                    contentDescription = stringResource(R.string.dog_image_content_description),
                    modifier = Modifier.fillMaxSize(),
                    loading = placeholder { dogImageLoading() },
                    failure = placeholder { dogImageError(stringResource(R.string.dog_image_error_message)) },
                )
            }
        }
    }
}

@Composable
fun dogImageLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(modifier = Modifier.size(64.dp))
    }
}

@Composable
fun dogImageError(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(message)
    }
}
