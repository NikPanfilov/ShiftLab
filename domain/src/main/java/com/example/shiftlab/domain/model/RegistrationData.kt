package com.example.shiftlab.domain.model

data class RegistrationData(
    val name: String,
    val surname: String,
    val birthDate: String,
    val password: String,
    val passwordRepeat: String
)
