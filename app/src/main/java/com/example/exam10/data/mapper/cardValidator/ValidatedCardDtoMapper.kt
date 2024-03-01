package com.example.exam10.data.mapper.cardValidator

import com.example.exam10.data.model.validatedCard.ValidatedCardDto
import com.example.exam10.domain.model.validatedCard.GetValidatedCard

fun ValidatedCardDto.toDomain() = GetValidatedCard(
    accountName = accountName,
    accountNumber = accountNumber,
    cardLogo = null,
    cardType = cardType,
    id = id,
    valuteType = valuteType
)