package com.example.exam10.data.model.story

import com.squareup.moshi.Json

data class AccountDto(
    @Json(name = "account_name")
    val accountName: String,
    @Json(name = "account_number")
    val accountNumber: String,
    val balance: Int,
    @Json(name = "card_logo")
    val cardLogo: Any?,
    @Json(name = "card_type")
    val cardType: String,
    val id: Int,
    @Json(name = "valute_type")
    val valuteType: String
)