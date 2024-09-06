package uk.co.jamiecruwys.showcase.settings.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asFlow
import uk.co.jamiecruwys.showcase.settings.R
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
            icon = R.drawable.notifications,
            iconContentDescription = "Notifications",
            title = "Daily Reminder Notifications",
            checked = userSettings.value.dailyReminderNotifications,
            onClick = { checked ->
                viewModel.setDailyReminderNotification(checked)
            },
        )
        actionSetting(
            icon = R.drawable.time,
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
            icon = R.drawable.palette,
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
            icon = R.drawable.fingerprint,
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
            icon = R.drawable.download,
            iconContentDescription = "Export",
            title = "Export entries to downloads folder",
            onClick = {},
        )
        actionSetting(
            icon = R.drawable.upload,
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
            icon = R.drawable.lock,
            iconContentDescription = "Privacy Policy",
            title = "Privacy Policy",
            onClick = {},
        )
        actionSetting(
            icon = R.drawable.article,
            iconContentDescription = "Terms & Conditions",
            title = "Terms & Conditions",
            onClick = {},
        )
        actionSetting(
            icon = R.drawable.info,
            iconContentDescription = "App version number",
            title = "Version number: x.x.x",
            onClick = {},
        )
    }
}
