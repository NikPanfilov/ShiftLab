package com.example.shiftlab.presentation.signupScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shiftlab.data.repository.UserRepositoryImpl
import com.example.shiftlab.data.storage.SharedPrefsUserStorage
import com.example.shiftlab.domain.usecase.LoadLocalUserUseCase
import com.example.shiftlab.domain.usecase.SaveLocalUserUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val repository by lazy {
        UserRepositoryImpl(SharedPrefsUserStorage(context = context))
    }

    private val saveLocalUserUseCase by lazy {
        SaveLocalUserUseCase(repository = repository)
    }

    private val loadLocalUserUseCase by lazy {
        LoadLocalUserUseCase(repository = repository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveLocalUserUseCase = saveLocalUserUseCase,
            loadLocalUserUseCase = loadLocalUserUseCase
        ) as T
    }
}