package uk.co.jamiecruwys.showcase.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun homeScreen(navController: NavController) {
    val paddingModifier = Modifier.padding(16.dp)

    Column(modifier = paddingModifier) {
        Text(text = "Hello World!", modifier = paddingModifier)
        Button(
            modifier = paddingModifier,
            onClick = { navController.navigate(Destinations.Dogs.route) }
        ) {
            Text("Dogs")
        }
        Button(
            modifier = paddingModifier,
            onClick = { navController.navigate(Destinations.Cats.route) }
        ) {
            Text("Cats")
        }
    }
}
