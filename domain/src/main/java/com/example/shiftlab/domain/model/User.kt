package com.example.shiftlab.domain.model

import java.time.LocalDate

data class User(
    val name: String,
    val surname: String,
    val birthDate: LocalDate,
    val password: String
)