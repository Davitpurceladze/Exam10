package com.example.exam10.presentation.mapper

import com.example.exam10.domain.model.story.GetAccount
import com.example.exam10.presentation.model.account.Account

fun GetAccount.toPresenter() = Account(
    accountName = accountName,
    accountNumber = accountNumber,
    balance = balance,
    cardLogo =cardLogo,
    cardType = cardType,
    id = id,
    valuteType = Account.Valute.valueOf(value = valuteType)
)