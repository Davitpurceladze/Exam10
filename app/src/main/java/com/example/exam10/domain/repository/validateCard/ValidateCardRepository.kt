package com.example.exam10.domain.repository.validateCard

import com.example.exam10.data.common.Resource
import com.example.exam10.domain.model.validatedCard.GetValidatedCard
import kotlinx.coroutines.flow.Flow

interface ValidateCardRepository {
    suspend fun fetchValidatedCard(validator: String) : Flow<Resource<GetValidatedCard>>
}