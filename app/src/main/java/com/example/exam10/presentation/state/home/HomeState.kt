package com.example.exam10.presentation.state.home

import com.example.exam10.presentation.model.account.Account

data class HomeState(
    val account: List<Account>? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)