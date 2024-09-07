package com.jamiescode.showcase.settings.data

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun getUserSettings(): Flow<UserSettings>

    suspend fun setDailyReminderNotifications(enabled: Boolean)

    suspend fun setUnlockWithBiometrics(enabled: Boolean)
}
