package com.example.exam10.di

import com.example.exam10.data.common.HandleResponse
import com.example.exam10.data.repository.Account.AccountRepositoryImpl
import com.example.exam10.data.repository.validatedCard.ValidatedCardRepositoryImpl
import com.example.exam10.data.service.account.AccountService
import com.example.exam10.data.service.validatedCard.ValidatedCardService
import com.example.exam10.domain.repository.Account.AccountRepository
import com.example.exam10.domain.repository.validateCard.ValidateCardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideStoryRepository(
        accountService: AccountService,
        handleResponse: HandleResponse
    ): AccountRepository {
        return AccountRepositoryImpl(
            accountService = accountService,
            handleResponse = handleResponse
        )
    }

    @Provides
    @Singleton
    fun provideValidatedCardRepository(
        handleResponse: HandleResponse,
        validatedCardService: ValidatedCardService
    ): ValidateCardRepository{
        return ValidatedCardRepositoryImpl(
            handleResponse = handleResponse,
            validatedCardService = validatedCardService
        )
    }
}