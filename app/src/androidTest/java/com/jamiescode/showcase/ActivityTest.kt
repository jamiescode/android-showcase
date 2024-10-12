package com.jamiescode.showcase

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.jamiescode.showcase.navigation.AppNavigator
import com.jamiescode.showcase.presentation.appComposable
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class MyActivityTest: ScreenshotTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun rendersTheDefaultComponent() {
        composeRule.setContent {
            appComposable(appNavigator = AppNavigator())
        }
        compareScreenshot(composeRule.onRoot())
    }
}
