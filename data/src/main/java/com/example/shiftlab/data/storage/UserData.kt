package com.example.shiftlab.data.storage

import java.time.LocalDate

data class UserData(
    val name: String,
    val surname: String,
    val birthDate: LocalDate,
    val password: String
)
