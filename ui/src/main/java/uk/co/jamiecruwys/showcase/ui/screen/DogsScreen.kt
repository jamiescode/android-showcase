package uk.co.jamiecruwys.showcase.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import timber.log.Timber
import uk.co.jamiecruwys.domain.DogViewModel

@Composable
fun DogsScreen(viewModel: DogViewModel = hiltViewModel()) {
    Timber.d("Showing dog screen")

    val state = viewModel.stateLiveData.asFlow().collectAsState(
        initial = DogViewModel.State(
            isLoading = true,
            isError = false,
            imageUrl = "",
        )
    )

    Column {
        Button(onClick = { viewModel.onRandomButtonPressed() }) {
            Text("Tap here for another dog")
        }
        Spacer(modifier = Modifier.height(50.dp))
        DogImageState(state = state.value)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DogImageState(state: DogViewModel.State) {
    if (state.isLoading) {
        Timber.d("Loading...")
        Text("Loading...")
    } else if (state.isError) {
        Timber.d("Error")
        Text("Error")
    } else if (state.imageUrl.isEmpty()) {
        Timber.d("Empty url")
        Text("Empty url")
    } else {
        Timber.d("Image url: ${state.imageUrl}")
        GlideImage(
            model = state.imageUrl,
            contentDescription = "Image of a dog",
            modifier = Modifier.size(300.dp)
        )
    }
}
