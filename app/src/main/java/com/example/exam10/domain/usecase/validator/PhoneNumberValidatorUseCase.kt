package com.example.exam10.domain.usecase.validator

import javax.inject.Inject

private const val EXPECTED_LENGTH = 9

class PhoneNumberValidatorUseCase @Inject constructor() {
    operator fun invoke(personalNumber: String) =
        personalNumber.length == EXPECTED_LENGTH
}