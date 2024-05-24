package uk.co.jamiecruwys.gratitude.presentation.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
import uk.co.jamiecruwys.gratitude.presentation.domain.usecase.AddGratitudeEntryUseCase
import uk.co.jamiecruwys.gratitude.presentation.domain.usecase.GetGratitudeEntriesUseCase
import javax.inject.Inject

@HiltViewModel
class GratitudeViewModel
    @Inject
    constructor(
        private val getGratitudeEntriesUseCase: GetGratitudeEntriesUseCase,
        private val addGratitudeEntryUseCase: AddGratitudeEntryUseCase,
    ) : ViewModel() {
        private val stateMutableLiveData: MutableLiveData<State> by lazy {
            MutableLiveData<State>(State.Initial)
        }

        val stateLiveData = stateMutableLiveData as LiveData<State>

        fun loadEntries() {
            viewModelScope.launch {
                getGratitudeEntriesUseCase.execute().also {
                    when (it) {
                        is GetGratitudeEntriesUseCase.Result.Success -> {
                            stateMutableLiveData.postValue(State.Loaded(it.gratitudeEntries))
                        }

                        is GetGratitudeEntriesUseCase.Result.Error -> {
                            stateMutableLiveData.postValue(State.Error)
                        }
                    }
                }
            }
        }

        fun addEntry(text: String) {
            val gratitudeEntry = GratitudeEntry(text = text)
            stateMutableLiveData.postValue(State.Loading)
            viewModelScope.launch {
                addGratitudeEntryUseCase.execute(gratitudeEntry).also {
                    when (it) {
                        is AddGratitudeEntryUseCase.Result.Success -> {
                            stateMutableLiveData.postValue(State.Loaded(it.gratitudeEntries))
                        }

                        is AddGratitudeEntryUseCase.Result.Error -> {
                            stateMutableLiveData.postValue(State.Error)
                        }
                    }
                }
            }
        }

        sealed class State {
            data object Initial : State()

            data object Loading : State()

            data object Error : State()

            data class Loaded(val gratitudeEntries: List<GratitudeEntry>) : State()
        }
    }
