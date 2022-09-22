package com.example.shiftlab.domain.model

data class RegistrationResult(
    val isNameCorrect: Boolean,
    val isSurnameCorrect: Boolean,
    val birthDate: Int,
    val isPasswordCorrect: Boolean,
    val isPasswordRepeatCorrect: Boolean
)
