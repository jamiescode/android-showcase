package com.jamiescode.showcase

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.jamiescode.showcase.gratitude.domain.usecase.AddGratitudeEntryUseCase
import com.jamiescode.showcase.gratitude.domain.usecase.DeleteGratitudeEntryUseCase
import com.jamiescode.showcase.gratitude.domain.usecase.GetGratitudeEntriesUseCase
import com.jamiescode.showcase.gratitude.presentation.screen.GratitudeViewModel
import com.jamiescode.showcase.gratitude.presentation.screen.gratitudeScreen
import com.karumi.shot.ScreenshotTest
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class ActivityTest: ScreenshotTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    @Inject
    lateinit var getGratitudeEntriesUseCase: GetGratitudeEntriesUseCase

    @Inject
    lateinit var addGratitudeEntryUseCase: AddGratitudeEntryUseCase

    @Inject
    lateinit var deleteGratitudeEntryUseCase: DeleteGratitudeEntryUseCase

    @BindValue
    @JvmField
    val viewModel = mockk<GratitudeViewModel>(relaxed = true)

    @Test
    fun rendersTheDefaultComponent() {
        hiltRule.inject()
        // I need to work out how to inject view models. If I do it directly, it crashes.
        // But if I provide the dependencies and create it myself, it works...
//        val viewModel = GratitudeViewModel(
//            getGratitudeEntriesUseCase,
//            addGratitudeEntryUseCase,
//            deleteGratitudeEntryUseCase,
//        )
        composeRule.setContent {
            gratitudeScreen(
                viewModel = viewModel,
                // This needs to be fixed so the tests can run when quotes are shown
                showQuotes = false,
            )
        }
        compareScreenshot(composeRule.onRoot())
    }
}
