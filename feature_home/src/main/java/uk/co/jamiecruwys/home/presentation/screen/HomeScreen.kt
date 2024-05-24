package uk.co.jamiecruwys.home.presentation.screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import uk.co.jamiecruwys.navigation.Destinations

@Composable
fun homeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Would you prefer to see pictures of cats or dogs?")

        Spacer(modifier = Modifier.height(32.dp))

        val buttonModifier = Modifier.fillMaxWidth().height(64.dp)
        Button(
            modifier = buttonModifier,
            onClick = {
                navController.navigate(Destinations.Cats.route)
            },
        ) {
            Text("Cats")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = buttonModifier,
            onClick = {
                navController.navigate(Destinations.Dogs.route)
            },
        ) {
            Text("Dogs")
        }
    }
}
