package uk.co.jamiecruwys.showcase.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import timber.log.Timber

@Composable
fun dogsScreen() {
    Timber.d("Showing dog screen")
    Box {
        Text(text = "Woof!")
    }
}
