package com.example.exam10.presentation.event.home

sealed class HomeEvent {
    data object FetchAccount :HomeEvent()
}