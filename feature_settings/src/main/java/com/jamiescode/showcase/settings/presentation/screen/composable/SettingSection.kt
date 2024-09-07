package com.jamiescode.showcase.settings.presentation.screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun settingSection(
    heading: String,
    content: @Composable () -> Unit,
) {
    Column {
        settingHeader(title = heading)
        content()
    }
}
