package com.example.shiftlab.presentation.mainScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shiftlab.data.repository.UserRepositoryImpl
import com.example.shiftlab.data.storage.SharedPrefsUserStorage
import com.example.shiftlab.domain.usecase.LoadLocalUserUseCase

class MainScreenViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val repository by lazy {
        UserRepositoryImpl(SharedPrefsUserStorage(context = context))
    }

    private val loadLocalUserUseCase by lazy {
        LoadLocalUserUseCase(repository = repository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainScreenViewModel(
            loadLocalUserUseCase = loadLocalUserUseCase
        ) as T
    }
}