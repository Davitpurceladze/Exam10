package com.example.exam10.domain.usecase.validator

import javax.inject.Inject


private const val EXPECTED_LENGTH = 11

class PersonalNumberValidatorUseCase @Inject constructor() {
    operator fun invoke(personalNumber: String) =
        personalNumber.length == EXPECTED_LENGTH
}