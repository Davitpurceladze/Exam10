package com.example.exam10.data.service.validatedCard

import com.example.exam10.data.model.story.AccountDto
import com.example.exam10.data.model.validatedCard.ValidatedCardDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ValidatedCardService {


    @GET("4253786f-3500-4148-9ebc-1fe7fb9dc8d5")
    suspend fun getValidatedCard( @Query("ValidatorNumber") validatorNumber: String): Response<ValidatedCardDto>
}