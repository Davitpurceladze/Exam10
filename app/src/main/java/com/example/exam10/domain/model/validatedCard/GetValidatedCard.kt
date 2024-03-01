package com.example.exam10.domain.model.validatedCard

data class GetValidatedCard(
    val accountName: String,
    val accountNumber: String,
    val cardLogo: Any?,
    val cardType: String,
    val id: Int,
    val valuteType: String
)
