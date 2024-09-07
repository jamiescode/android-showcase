package com.jamiescode.showcase.construction.presentation.screen

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
import com.jamiescode.showcase.construction.R
import timber.log.Timber

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun underConstructionImageState(state: UnderConstructionViewModel.State) {
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
            is UnderConstructionViewModel.State.Initial -> {
                // Show nothing
            }
            is UnderConstructionViewModel.State.Error -> {
                underConstructionImageError(message = stringResource(R.string.under_construction_image_error_message))
            }
            is UnderConstructionViewModel.State.ImageAvailable -> {
                Timber.d("Image url: ${state.imageUrl}")
                GlideImage(
                    model = state.imageUrl,
                    contentDescription = stringResource(R.string.under_construction_image_content_description),
                    modifier = Modifier.fillMaxSize(),
                    loading = placeholder { underConstructionImageLoading() },
                    failure = placeholder { underConstructionImageError(stringResource(R.string.under_construction_image_error_message)) },
                )
            }
        }
    }
}

@Composable
fun underConstructionImageLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(modifier = Modifier.size(64.dp))
    }
}

@Composable
fun underConstructionImageError(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(message)
    }
}
