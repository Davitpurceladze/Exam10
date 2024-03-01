package com.example.exam10.domain.repository.Account

import com.example.exam10.data.common.Resource
import com.example.exam10.domain.model.story.GetAccount
import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    suspend fun fetchAccount() : Flow<Resource<List<GetAccount>>>
}