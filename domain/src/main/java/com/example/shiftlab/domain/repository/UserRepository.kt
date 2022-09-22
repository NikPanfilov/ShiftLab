package com.example.shiftlab.domain.repository

import com.example.shiftlab.domain.model.User

interface UserRepository {
    fun saveUser(user: User)
    fun loadUser(): User
}