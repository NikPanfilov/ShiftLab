package com.example.shiftlab.data.storage

interface UserStorage {
    fun saveUser(user: UserData)

    fun loadUser(): UserData
}