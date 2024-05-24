package uk.co.jamiecruwys.showcase.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import timber.log.Timber
import uk.co.jamiecruwys.domain.DogViewModel

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
                dogImageError(message = "Error: Failed to load data")
            }
            is DogViewModel.State.ImageAvailable -> {
                Timber.d("Image url: ${state.imageUrl}")
                GlideImage(
                    model = state.imageUrl,
                    contentDescription = "Image of a dog",
                    modifier = Modifier.fillMaxSize(),
                    loading = placeholder { dogImageLoading() },
                    failure = placeholder { dogImageError("Error: Failed to load image") },
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
