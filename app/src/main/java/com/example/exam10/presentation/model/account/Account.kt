package com.example.exam10.presentation.model.account

data class Account(
    val accountName: String,
    val accountNumber: String,
    val balance: Int,
    val cardLogo: Any?,
    val cardType: String,
    val id: Int,
    val valuteType: Valute
) {
    enum class Valute{
        GEL, USD, EUR
    }
}
