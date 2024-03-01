package com.example.exam10.data.mapper.account

import com.example.exam10.data.model.story.AccountDto
import com.example.exam10.domain.model.story.GetAccount


fun AccountDto.toDomain() = GetAccount(
    accountName = accountName,
    accountNumber = accountNumber,
    balance = balance,
    cardLogo =cardLogo,
    cardType = cardType,
    id = id,
    valuteType = valuteType
)