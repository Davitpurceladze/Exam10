package com.example.exam10.presentation.screen.toAccountBottomSheet

import androidx.lifecycle.ViewModel
import com.example.exam10.domain.usecase.validator.AccountNumberValidatorUseCase
import com.example.exam10.domain.usecase.validator.PersonalNumberValidatorUseCase
import com.example.exam10.domain.usecase.validator.PhoneNumberValidatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToAccountBottomSheetFragmentViewModel @Inject constructor(
    private val accountNumberValidator : AccountNumberValidatorUseCase,
    private val personalNumberValidator : PersonalNumberValidatorUseCase,
    private val phoneNumberValidator : PhoneNumberValidatorUseCase
): ViewModel() {
}