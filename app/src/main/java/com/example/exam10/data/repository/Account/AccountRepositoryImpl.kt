package com.example.exam10.data.repository.Account

import com.example.exam10.data.common.HandleResponse
import com.example.exam10.data.common.Resource
import com.example.exam10.data.mapper.base.asResource
import com.example.exam10.data.mapper.account.toDomain
import com.example.exam10.data.service.account.AccountService
import com.example.exam10.domain.model.story.GetAccount
import com.example.exam10.domain.repository.Account.AccountRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val accountService: AccountService
) : AccountRepository {
    override suspend fun fetchAccount(): Flow<Resource<List<GetAccount>>> {
        return handleResponse.safeApiCall {
            accountService.getAccount()
        }.asResource {
            it.map {
                it.toDomain()
            }
        }
    }
}