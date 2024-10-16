package com.jamiescode.showcase.gratitude.presentation.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamiescode.showcase.gratitude.domain.model.GratitudeEntry
import com.jamiescode.showcase.gratitude.domain.usecase.AddGratitudeEntryUseCase
import com.jamiescode.showcase.gratitude.domain.usecase.DeleteGratitudeEntryUseCase
import com.jamiescode.showcase.gratitude.domain.usecase.GetGratitudeEntriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GratitudeViewModel
    @Inject
    constructor(
        private val getGratitudeEntriesUseCase: GetGratitudeEntriesUseCase,
        private val addGratitudeEntryUseCase: AddGratitudeEntryUseCase,
        private val deleteGratitudeEntryUseCase: DeleteGratitudeEntryUseCase,
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
                            val value = State.Loaded(entries)
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

        fun deleteEntry(gratitudeEntry: GratitudeEntry) {
            stateMutableLiveData.postValue(State.Loading)
            viewModelScope.launch {
                deleteGratitudeEntryUseCase.execute(gratitudeEntry).also {
                    when (it) {
                        is DeleteGratitudeEntryUseCase.Result.Success -> {
                            stateMutableLiveData.postValue(State.Loaded(it.gratitudeEntries))
                        }

                        is DeleteGratitudeEntryUseCase.Result.Error -> {
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
        }

        sealed class ScrollState {
            data object Idle : ScrollState()

            data object Scroll : ScrollState()
        }
    }
