package com.example.shiftlab.domain.validator

class ValidatePasswordRepeat {
    fun validate(password: String, password2: String): Boolean {
        return (password == password2)
    }
}