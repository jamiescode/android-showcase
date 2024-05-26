package uk.co.jamiecruwys.showcase.settings.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow
import uk.co.jamiecruwys.showcase.settings.data.UserSettings
import uk.co.jamiecruwys.showcase.settings.presentation.screen.composable.actionSetting
import uk.co.jamiecruwys.showcase.settings.presentation.screen.composable.settingSection
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
        is SettingsViewModel.SettingsState.Initial -> settingsInitialState()
        is SettingsViewModel.SettingsState.Loaded -> {
            val userSettings = state.userSettings.collectAsState(initial = UserSettings())
            val scrollState = rememberScrollState()
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
            ) {
                notificationsSection(viewModel, userSettings)
                appearanceSection()
                securitySection(viewModel, userSettings)
                backupAndRestoreSection()
                appInformationSection()
            }
        }
    }
}

@Composable
fun settingsInitialState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun notificationsSection(
    viewModel: SettingsViewModel,
    userSettings: State<UserSettings>,
) {
    settingSection(heading = "Notifications") {
        switchSetting(
            icon = Icons.Filled.Notifications,
            iconContentDescription = "Notifications",
            title = "Daily Reminder Notifications",
            checked = userSettings.value.dailyReminderNotifications,
            onClick = { checked ->
                viewModel.setDailyReminderNotification(checked)
            },
        )
        actionSetting(
            icon = Icons.Filled.DateRange,
            iconContentDescription = "Time",
            title = "Change your daily reminder time",
            onClick = {},
        )
    }
}

@Composable
fun appearanceSection() {
    settingSection(heading = "Appearance") {
        actionSetting(
            icon = Icons.Filled.Star,
            iconContentDescription = "Theme",
            title = "Choose a theme",
            onClick = {},
        )
    }
}

@Composable
fun securitySection(
    viewModel: SettingsViewModel,
    userSettings: State<UserSettings>,
) {
    settingSection(heading = "Security") {
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

@Composable
fun backupAndRestoreSection() {
    settingSection(heading = "Backup & Restore") {
        actionSetting(
            icon = Icons.Filled.KeyboardArrowDown,
            iconContentDescription = "Export",
            title = "Export entries to downloads folder",
            onClick = {},
        )
        actionSetting(
            icon = Icons.Filled.KeyboardArrowUp,
            iconContentDescription = "Import",
            title = "Import entries from a CSV file",
            onClick = {},
        )
    }
}

@Composable
fun appInformationSection() {
    settingSection(heading = "App Information") {
        actionSetting(
            icon = Icons.Outlined.Lock,
            iconContentDescription = "Privacy Policy",
            title = "Privacy Policy",
            onClick = {},
        )
        actionSetting(
            icon = Icons.Outlined.Email,
            iconContentDescription = "Terms & Conditions",
            title = "Terms & Conditions",
            onClick = {},
        )
        actionSetting(
            icon = Icons.Outlined.Info,
            iconContentDescription = "App version number",
            title = "Version number: x.x.x",
            onClick = {},
        )
    }
}
