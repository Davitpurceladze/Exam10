package com.example.exam10.data.service.account

import com.example.exam10.data.model.story.AccountDto
import retrofit2.Response
import retrofit2.http.GET

interface AccountService {

    @GET("5c74ec0e-5cc1-445e-b64b-b76b286b215f/data")
    suspend fun getAccount(): Response<List<AccountDto>>
}