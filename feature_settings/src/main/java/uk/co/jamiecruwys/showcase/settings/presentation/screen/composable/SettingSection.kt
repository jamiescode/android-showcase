package uk.co.jamiecruwys.showcase.settings.presentation.screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun SettingSection(
    heading: String,
    content: @Composable () -> Unit,
) {
    Column {
        SettingHeader(title = heading)
        content()
    }
}
