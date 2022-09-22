package com.example.shiftlab.domain.validator

class ValidateSurname {
    fun validate(name: String): Boolean {
        return (name.contains(Regex("""^([a-z]+)|([а-я]+)$""", RegexOption.IGNORE_CASE)))
    }
}