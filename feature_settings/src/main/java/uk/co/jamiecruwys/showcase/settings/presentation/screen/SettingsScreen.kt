package uk.co.jamiecruwys.showcase.settings.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow
import uk.co.jamiecruwys.showcase.settings.data.UserSettings
import uk.co.jamiecruwys.showcase.settings.presentation.screen.composable.switchSetting

@Composable
fun settingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.load()
    }

    val liveData =
        viewModel.stateLiveData.asFlow().collectAsState(
            initial = SettingsViewModel.SettingsState.Initial,
        )

    when (val state = liveData.value) {
        is SettingsViewModel.SettingsState.Initial -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }
        is SettingsViewModel.SettingsState.Loaded -> {
            val userSettings = state.userSettings.collectAsState(initial = UserSettings())
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                switchSetting(
                    icon = Icons.Filled.Notifications,
                    iconContentDescription = "Notifications",
                    title = "Daily Reminder Notifications",
                    checked = userSettings.value.dailyReminderNotifications,
                    onClick = { checked ->
                        viewModel.setDailyReminderNotification(checked)
                    },
                )
                switchSetting(
                    icon = Icons.Outlined.Lock,
                    iconContentDescription = "Security",
                    title = "Unlock with biometrics",
                    checked = userSettings.value.unlockWithBiometrics,
                    onClick = { checked ->
                        viewModel.setUnlockWithBiometrics(checked)
                    },
                )
            }
        }
    }
}
