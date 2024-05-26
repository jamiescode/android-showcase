package uk.co.jamiecruwys.showcase.settings.presentation.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import uk.co.jamiecruwys.showcase.settings.data.SettingsRepository
import uk.co.jamiecruwys.showcase.settings.data.UserSettings
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
    @Inject
    constructor(private val settingsRepository: SettingsRepository) : ViewModel() {
        private val stateMutableLiveData: MutableLiveData<SettingsState> by lazy {
            MutableLiveData<SettingsState>(SettingsState.Initial)
        }
        val stateLiveData = stateMutableLiveData as LiveData<SettingsState>

        fun load() {
            viewModelScope.launch {
                val userSettings = settingsRepository.getUserSettings()
                stateMutableLiveData.postValue(SettingsState.Loaded(userSettings))
            }
        }

        fun setDailyReminderNotification(checked: Boolean) {
            viewModelScope.launch {
                settingsRepository.setDailyReminderNotifications(checked)
            }
            load()
        }

        fun setUnlockWithBiometrics(checked: Boolean) {
            viewModelScope.launch {
                settingsRepository.setUnlockWithBiometrics(checked)
            }
            load()
        }

        sealed class SettingsState {
            data object Initial : SettingsState()

            data class Loaded(val userSettings: Flow<UserSettings>) : SettingsState()
        }
    }
