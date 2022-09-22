package com.example.shiftlab.domain.usecase

import com.example.shiftlab.domain.model.User
import com.example.shiftlab.domain.repository.UserRepository

class LoadLocalUserUseCase(private val repository: UserRepository) {
    fun execute(): User {
        return repository.loadUser()
    }
}