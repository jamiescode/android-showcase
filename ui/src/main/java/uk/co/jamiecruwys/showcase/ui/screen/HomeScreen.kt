package uk.co.jamiecruwys.showcase.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import timber.log.Timber
import uk.co.jamiecruwys.showcase.ui.UiNavigationEvent

@Composable
fun homeScreen(sendUiNavigationEvent: (UiNavigationEvent) -> Unit) {
    Timber.d("Showing home screen")

    val paddingModifier = Modifier.padding(16.dp)

    Column(modifier = paddingModifier) {
        Text(text = "Hello World!", modifier = paddingModifier)
        Button(
            modifier = paddingModifier,
            onClick = {
                sendUiNavigationEvent(UiNavigationEvent.DOG)
            },
        ) {
            Text("Dogs")
        }
        Button(
            modifier = paddingModifier,
            onClick = {
                sendUiNavigationEvent(UiNavigationEvent.CAT)
            },
        ) {
            Text("Cats")
        }
    }
}
