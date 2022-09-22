package com.example.shiftlab.domain

import com.example.shiftlab.domain.model.RegistrationData
import com.example.shiftlab.domain.model.User
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegistrationDataToUser {
    fun execute(data: RegistrationData): User {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return User(
            data.name,
            data.surname,
            LocalDate.parse(data.birthDate, formatter),
            data.password,
        )
    }
}