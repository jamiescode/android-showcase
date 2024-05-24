package uk.co.jamiecruwys.cat.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import timber.log.Timber

@Composable
fun catsScreen() {
    Timber.d("Showing cat screen")
    Box {
        Text(text = "Meow!")
    }
}
