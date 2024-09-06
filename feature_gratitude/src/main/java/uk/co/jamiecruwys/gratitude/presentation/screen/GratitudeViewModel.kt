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

        private val scrollMutableLiveData: MutableLiveData<ScrollState> by lazy {
            MutableLiveData<ScrollState>(ScrollState.Idle)
        }
        val scrollLiveData = scrollMutableLiveData as LiveData<ScrollState>

        fun loadEntries() {
            viewModelScope.launch {
                getGratitudeEntriesUseCase.execute().also {
                    when (it) {
                        is GetGratitudeEntriesUseCase.Result.Success -> {
                            val entries = it.gratitudeEntries
                            val value =
                                if (entries.isEmpty()) {
                                    State.Empty
                                } else {
                                    State.Loaded(entries)
                                }
                            stateMutableLiveData.postValue(value)
                        }

                        is GetGratitudeEntriesUseCase.Result.Error -> {
                            stateMutableLiveData.postValue(State.Error)
                        }
                    }
                }
            }
        }

        fun addEntry(text: String) {
            val gratitudeEntry = GratitudeEntry(entry = text)
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

        fun scrollListToNewItem() {
            scrollMutableLiveData.postValue(ScrollState.Scroll)
        }

        sealed class State {
            data object Initial : State()

            data object Loading : State()

            data object Error : State()

            data class Loaded(
                val gratitudeEntries: Map<String, List<GratitudeEntry>>,
            ) : State()

            data object Empty : State()
        }

        sealed class ScrollState {
            data object Idle : ScrollState()

            data object Scroll : ScrollState()
        }
    }
