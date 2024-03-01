package com.example.exam10.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exam10.domain.usecase.story.GetAccountUseCase
import com.example.exam10.presentation.event.home.HomeEvent
import com.example.exam10.presentation.state.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val storyRepository: GetAccountUseCase
): ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: SharedFlow<HomeState> = _homeState.asStateFlow()


    fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.FetchAccount -> fetchAccount()
        }
    }

    private fun fetchAccount() {
        viewModelScope.launch {
            storyRepository().collect{
//
            }
        }
    }
}