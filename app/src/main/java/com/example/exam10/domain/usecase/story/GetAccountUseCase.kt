package com.example.exam10.domain.usecase.story

import com.example.exam10.domain.repository.Account.AccountRepository
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {
    suspend operator fun invoke() = accountRepository.fetchAccount()
}