package com.example.exam10.presentation.screen.fromAccountBottomSheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exam10.data.common.Resource
import com.example.exam10.data.service.account.AccountService
import com.example.exam10.domain.usecase.story.GetAccountUseCase
import com.example.exam10.presentation.event.from_account.FromAccountEvent
import com.example.exam10.presentation.mapper.toPresenter
import com.example.exam10.presentation.state.from_account.FromAccountBottomSheetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FromAccountBottomSheetFragmentViewModel @Inject constructor(
 private val getAccount: GetAccountUseCase
): ViewModel() {

    private val _fromAccountBottomSheetState = MutableStateFlow(FromAccountBottomSheetState())
    val fromAccountBottomSheetState: SharedFlow<FromAccountBottomSheetState> = _fromAccountBottomSheetState.asStateFlow()

     fun onEvent(event: FromAccountEvent) {
         when(event) {
             is FromAccountEvent.FetchAccount -> fetchAccount()
         }
     }

    private fun fetchAccount() {
        viewModelScope.launch {
            getAccount().collect{
                when (it) {
                    is Resource.Loading -> _fromAccountBottomSheetState.update { currentState ->
                        currentState.copy(
                            isLoading = it.loading
                        )
                    }

                    is Resource.Error -> _fromAccountBottomSheetState.update { currentState ->
                        currentState.copy(
                            errorMessage = it.errorMessage
                        )
                    }

                    is Resource.Success -> {
                        _fromAccountBottomSheetState.update { currentState ->
                            currentState.copy(
                                account = it.data.map {
                                    it.toPresenter()
                                }
                            )
                        }
                    }
                }
            }
        }
    }


}