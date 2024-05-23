package uk.co.jamiecruwys.showcase.ui.screen

import android.widget.Spinner
import androidx.compose.foundation.layout.Arrangement
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
import timber.log.Timber
import uk.co.jamiecruwys.domain.DogViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun dogImageState(state: DogViewModel.State) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (state) {
            is DogViewModel.State.Initial -> {
                // Show nothing
            }
            is DogViewModel.State.Loading -> {
                CircularProgressIndicator(modifier = Modifier.size(64.dp))
            }
            is DogViewModel.State.Error -> {
                Text("Error")
            }
            is DogViewModel.State.Loaded -> {
                Timber.d("Image url: ${state.imageUrl}")
                GlideImage(
                    model = state.imageUrl,
                    contentDescription = "Image of a dog",
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}