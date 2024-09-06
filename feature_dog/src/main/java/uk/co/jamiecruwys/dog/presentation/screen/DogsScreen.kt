package uk.co.jamiecruwys.dog.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow
import uk.co.jamiecruwys.showcase.dog.R

@Composable
fun dogsScreen(viewModel: DogViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.onRandomButtonPressed()
    }

    val state =
        viewModel.stateLiveData.asFlow().collectAsState(
            initial = DogViewModel.State.Initial,
        )

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        dogImageState(state = state.value)
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(64.dp),
            onClick = { viewModel.onRandomButtonPressed() },
        ) {
            Text(text = stringResource(R.string.dog_image_button_text))
        }
    }
}
