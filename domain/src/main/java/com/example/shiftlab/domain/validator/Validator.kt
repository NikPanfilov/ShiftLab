package com.example.shiftlab.domain.validator

import com.example.shiftlab.domain.model.RegistrationData
import com.example.shiftlab.domain.model.RegistrationResult

class Validator {
    fun validate(data: RegistrationData): RegistrationResult {
        return RegistrationResult(
            isNameCorrect = ValidateName().validate(data.name),
            isSurnameCorrect = ValidateSurname().validate(data.surname),
            birthDate = ValidateBirthDate().validate(data.birthDate),
            isPasswordCorrect = ValidatePassword().validate(data.password),
            isPasswordRepeatCorrect = ValidatePasswordRepeat().validate(
                data.password,
                data.passwordRepeat
            ),
        )
    }
}