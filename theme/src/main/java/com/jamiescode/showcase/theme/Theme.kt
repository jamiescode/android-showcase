package com.jamiescode.showcase.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val lightThemeColors =
    lightColorScheme(
        background = Color.White,
        surfaceContainer = Color.White,
        surface = Color.White,
    )

private val darkThemeColors = darkColorScheme()

private val typography = Typography()

@Composable
fun showcaseTheme(content: @Composable () -> Unit) {
    val colorScheme = if (isSystemInDarkTheme()) darkThemeColors else lightThemeColors
    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content,
    )
}
