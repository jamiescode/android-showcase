package com.jamiescode.showcase.quote.presentation.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamiescode.showcase.quote.domain.model.Quote
import com.jamiescode.showcase.quote.domain.usecase.GetQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel
    @Inject
    constructor(
        private val getQuoteUseCase: GetQuoteUseCase,
    ) : ViewModel() {
        private val stateMutableLiveData: MutableLiveData<State> by lazy {
            MutableLiveData<State>(State.Initial)
        }

        val stateLiveData = stateMutableLiveData as LiveData<State>

        fun loadQuotes() {
            stateMutableLiveData.postValue(State.Loading)
            viewModelScope.launch {
                getQuoteUseCase.execute().also {
                    when (it) {
                        is GetQuoteUseCase.Result.Success -> {
                            stateMutableLiveData.postValue(State.Success(it.quote))
                        }
                        is GetQuoteUseCase.Result.Error -> {
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

            data class Success(
                val quote: Quote,
            ) : State()
        }
    }
