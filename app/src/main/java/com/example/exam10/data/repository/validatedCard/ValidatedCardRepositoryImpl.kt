package com.example.exam10.data.repository.validatedCard

import com.example.exam10.data.common.HandleResponse
import com.example.exam10.data.common.Resource
import com.example.exam10.data.mapper.base.asResource
import com.example.exam10.data.mapper.cardValidator.toDomain
import com.example.exam10.data.service.validatedCard.ValidatedCardService
import com.example.exam10.domain.model.validatedCard.GetValidatedCard
import com.example.exam10.domain.repository.validateCard.ValidateCardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ValidatedCardRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val validatedCardService: ValidatedCardService
) : ValidateCardRepository {
    override suspend fun fetchValidatedCard(validator: String): Flow<Resource<GetValidatedCard>> {
        return handleResponse.safeApiCall {
            validatedCardService.getValidatedCard(validator)
        }.asResource {
            it.toDomain()
        }
    }
}