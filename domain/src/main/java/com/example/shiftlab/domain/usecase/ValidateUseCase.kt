package com.example.shiftlab.domain.usecase

import com.example.shiftlab.domain.model.RegistrationData
import com.example.shiftlab.domain.model.RegistrationResult
import com.example.shiftlab.domain.validator.Validator

class ValidateUseCase {
    fun execute(data: RegistrationData): RegistrationResult {
        return Validator().validate(data)
    }
}