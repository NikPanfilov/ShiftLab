package com.example.shiftlab.domain.validator

import com.example.shiftlab.domain.model.BirthDateCheckResult
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ValidateBirthDate {
    fun validate(dateRaw: String): Int {
        val date: LocalDate
        try {
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            date = LocalDate.parse(dateRaw, formatter)
        } catch (e: Exception) {
            return BirthDateCheckResult.INVALID_DATE_FORMAT
        }

        if (date > LocalDate.now().minusYears(5) ||
            date < LocalDate.now().minusYears(100)
        )
            return BirthDateCheckResult.INVALID_DATE
        return BirthDateCheckResult.OK
    }
}