package com.example.shiftlab.domain.usecase

import com.example.shiftlab.domain.model.User
import com.example.shiftlab.domain.repository.UserRepository

class SaveLocalUserUseCase(private val repository: UserRepository) {

    fun execute(user: User) {
        repository.saveUser(user)
    }
}