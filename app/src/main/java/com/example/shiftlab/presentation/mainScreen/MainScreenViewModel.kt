package com.example.shiftlab.presentation.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shiftlab.domain.model.User
import com.example.shiftlab.domain.usecase.LoadLocalUserUseCase

class MainScreenViewModel(
    private val loadLocalUserUseCase: LoadLocalUserUseCase
) : ViewModel() {

    private val userLive = MutableLiveData<User>()
    val user: LiveData<User> = userLive

    fun loadUser() {
        userLive.value = loadLocalUserUseCase.execute()
    }
}