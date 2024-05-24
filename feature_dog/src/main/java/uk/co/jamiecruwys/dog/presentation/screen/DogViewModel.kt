package uk.co.jamiecruwys.dog.presentation.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel
    @Inject
    constructor(
        private val getRandomDogImageUseCase: uk.co.jamiecruwys.dog.domain.usecase.GetDogImageUseCase,
    ) : ViewModel() {
        private val stateMutableLiveData: MutableLiveData<State> by lazy {
            MutableLiveData<State>(State.Initial)
        }

        val stateLiveData = stateMutableLiveData as LiveData<State>

        fun onRandomButtonPressed() {
            viewModelScope.launch {
                getRandomDogImageUseCase.execute().also {
                    when (it) {
                        is uk.co.jamiecruwys.dog.domain.usecase.GetDogImageUseCase.Result.Success -> {
                            stateMutableLiveData.postValue(State.ImageAvailable(it.imageUrl))
                        }
                        is uk.co.jamiecruwys.dog.domain.usecase.GetDogImageUseCase.Result.Error -> {
                            stateMutableLiveData.postValue(State.Error)
                        }
                    }
                }
            }
        }

        sealed class State {
            data object Initial : State()

            data object Error : State()

            data class ImageAvailable(val imageUrl: String) : State()
        }
    }
