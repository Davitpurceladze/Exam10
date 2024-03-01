package com.example.exam10.presentation.event.from_account

sealed class FromAccountEvent {
    data object FetchAccount: FromAccountEvent()
}