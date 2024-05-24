package uk.co.jamiecruwys.home.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.jamiecruwys.showcase.ui.UiNavigationEvent

@Composable
fun homeScreen(sendUiNavigationEvent: (UiNavigationEvent) -> Unit) {
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
