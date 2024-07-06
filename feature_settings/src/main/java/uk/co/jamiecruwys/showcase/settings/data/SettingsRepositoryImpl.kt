package uk.co.jamiecruwys.showcase.settings.data

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsRepositoryImpl
    @Inject
    constructor(dataStoreManager: DataStoreManager) : SettingsRepository {
        private val dataStore = dataStoreManager.get()
        private val dailyRemindersPrefKey = booleanPreferencesKey("dailyReminderNotifications")
        private val unlockWithBiometricsPrefKey = booleanPreferencesKey("unlockWithBiometrics")

        override suspend fun getUserSettings(): Flow<UserSettings> =
            dataStore.data.map { preferences ->
                UserSettings(
                    dailyReminderNotifications = preferences[dailyRemindersPrefKey] ?: false,
                    unlockWithBiometrics = preferences[unlockWithBiometricsPrefKey] ?: false,
                )
            }

        override suspend fun setDailyReminderNotifications(enabled: Boolean) {
            dataStore.edit { preferences ->
                preferences[dailyRemindersPrefKey] = enabled
            }
        }

        override suspend fun setUnlockWithBiometrics(enabled: Boolean) {
            dataStore.edit { preferences ->
                preferences[unlockWithBiometricsPrefKey] = enabled
            }
        }
    }
