package com.example.shiftlab.data.repository

import com.example.shiftlab.data.storage.UserData
import com.example.shiftlab.data.storage.UserStorage
import com.example.shiftlab.domain.model.User
import com.example.shiftlab.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveUser(user: User) {

        val userData = UserData(
            name = user.name,
            surname = user.surname,
            birthDate = user.birthDate,
            password = user.password
        )

        userStorage.saveUser(userData)
    }

    override fun loadUser(): User {
        val userData = userStorage.loadUser()

        return User(
            name = userData.name,
            surname = userData.surname,
            birthDate = userData.birthDate,
            password = userData.password
        )
    }
}