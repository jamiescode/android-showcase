package com.jamiescode.showcase.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource

@Composable
fun getIconColor() = colorResource(id = R.color.appBarIconColor)

@Composable
fun getListColors() =
    listOf(
        colorResource(id = R.color.listColorPurple),
        colorResource(id = R.color.listColorRed),
        colorResource(id = R.color.listColorOrange),
        colorResource(id = R.color.listColorBlue),
        colorResource(id = R.color.listColorPink),
        colorResource(id = R.color.listColorAmber),
        colorResource(id = R.color.listColorCyan),
        colorResource(id = R.color.listColorGreen),
        colorResource(id = R.color.listColorTeal),
    )
