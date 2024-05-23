package uk.co.jamiecruwys.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uk.co.jamiecruwys.domain.usecase.GetDogImageUseCase
import javax.inject.Inject

@HiltViewModel
class DogViewModel
    @Inject
    constructor(
        private val getRandomDogImageUseCase: GetDogImageUseCase,
    ) : ViewModel() {
        private val stateMutableLiveData: MutableLiveData<State> by lazy {
            MutableLiveData<State>(State.Initial)
        }

        val stateLiveData = stateMutableLiveData as LiveData<State>

        fun onRandomButtonPressed() {
            stateMutableLiveData.postValue(State.Loading)

            viewModelScope.launch {
                getRandomDogImageUseCase.execute().also {
                    when (it) {
                        is GetDogImageUseCase.Result.Success -> {
                            stateMutableLiveData.postValue(State.Loaded(it.imageUrl))
                        }
                        is GetDogImageUseCase.Result.Error -> {
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

            data class Loaded(val imageUrl: String) : State()
        }
    }
