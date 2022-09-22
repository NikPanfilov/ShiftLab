package com.example.shiftlab.data.storage

import android.content.Context
import android.content.SharedPreferences
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SharedPrefsUserStorage(context: Context) : UserStorage {
    companion object {
        const val SHARED_PREFERENCES_FILENAME = "userData"
        const val NAME = "user_name"
        const val SURNAME = "user_surname"
        const val BIRTHDATE = "user_birthdate"
        const val PASSWORD = "user_password"
    }

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_FILENAME, Context.MODE_PRIVATE)

    override fun saveUser(user: UserData) {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

        val e: SharedPreferences.Editor = sharedPreferences.edit()
        e.putString(NAME, user.name)
        e.putString(SURNAME, user.surname)
        e.putString(BIRTHDATE, user.birthDate.format(formatter).toString())
        e.putString(PASSWORD, user.password)
        e.apply()
    }

    override fun loadUser(): UserData {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val date = sharedPreferences.getString(BIRTHDATE, "01.01.2077")

        return UserData(
            sharedPreferences.getString(NAME, "") ?: "",
            sharedPreferences.getString(SURNAME, "") ?: "",
            LocalDate.parse(date, formatter),
            sharedPreferences.getString(PASSWORD, "") ?: "",
        )
    }
}