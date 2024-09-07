package com.jamiescode.showcase.settings.data

data class UserSettings(
    val dailyReminderNotifications: Boolean = false,
    val unlockWithBiometrics: Boolean = false,
)
