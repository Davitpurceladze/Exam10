package com.example.exam10.presentation.state.from_account

import com.example.exam10.presentation.model.account.Account

data class FromAccountBottomSheetState (
    val account: List<Account>? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)