package com.example.exam10.domain.model.story

import com.squareup.moshi.Json

data class GetAccount(
    val accountName: String,
    val accountNumber: String,
    val balance: Int,
    val cardLogo: Any?,
    val cardType: String,
    val id: Int,
    val valuteType: String
)
