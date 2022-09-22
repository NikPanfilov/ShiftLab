package com.example.shiftlab.domain.validator

class ValidateName {
    fun validate(name: String): Boolean {
        return (name.contains(Regex("""^([a-z]+)|([а-я]+)$""", RegexOption.IGNORE_CASE)))
    }
}