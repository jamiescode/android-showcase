package com.jamiescode.showcase.settings.domain.repository

import com.jamiescode.showcase.settings.data.UserSettings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun getUserSettings(): Flow<UserSettings>

    suspend fun setDailyReminderNotifications(enabled: Boolean)

    suspend fun setUnlockWithBiometrics(enabled: Boolean)
}
