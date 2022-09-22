package com.example.shiftlab.domain.validator

class ValidatePassword {
    fun validate(password: String): Boolean {
        return (password.contains(Regex("""\d""")) &&
                password.contains(Regex("""[A-Za-z]"""))
                )
    }
}