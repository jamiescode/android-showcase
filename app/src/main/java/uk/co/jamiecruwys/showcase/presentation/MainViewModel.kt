package uk.co.jamiecruwys.showcase.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.kodein.di.DIAware
import org.kodein.di.android.x.di
import uk.co.jamiecruwys.showcase.domain.usecase.GetDogImageUseCase

class MainViewModel(
    private val app: Application,
    private val getRandomDogImageUseCase: GetDogImageUseCase
) : AndroidViewModel(app), DIAware {

    override val di by di()

    private val stateMutableLiveData: MutableLiveData<State> by lazy {
        MutableLiveData<State>(
            State(
                isLoading = false,
                isError = false,
                imageUrl = ""
            )
        )
    }

    val stateLiveData = stateMutableLiveData as LiveData<State>

    fun onRandomButtonPressed() {
        stateMutableLiveData.postValue(
            State(
                isLoading = true,
                isError = false,
                imageUrl = ""
            )
        )

        viewModelScope.launch {
            getRandomDogImageUseCase.execute().also {
                when (it) {
                    is GetDogImageUseCase.Result.Success -> {
                        stateMutableLiveData.postValue(
                            State(
                                isLoading = true,
                                isError = false,
                                imageUrl = it.imageUrl
                            )
                        )
                    }
                    is GetDogImageUseCase.Result.Error -> {
                        stateMutableLiveData.postValue(
                            State(
                                isLoading = false,
                                isError = true,
                                imageUrl = ""
                            )
                        )
                    }
                }
            }
        }
    }

    fun onImageLoaded(lastState: State) {
        stateMutableLiveData.postValue(lastState.copy(isLoading = false))
    }

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val imageUrl: String = ""
    )
}
