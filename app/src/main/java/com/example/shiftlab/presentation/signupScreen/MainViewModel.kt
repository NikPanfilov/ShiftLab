package com.example.shiftlab.presentation.signupScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shiftlab.domain.RegistrationDataToUser
import com.example.shiftlab.domain.model.BirthDateCheckResult
import com.example.shiftlab.domain.model.RegistrationData
import com.example.shiftlab.domain.model.RegistrationResult
import com.example.shiftlab.domain.model.User
import com.example.shiftlab.domain.usecase.LoadLocalUserUseCase
import com.example.shiftlab.domain.usecase.SaveLocalUserUseCase
import com.example.shiftlab.domain.usecase.ValidateUseCase

class MainViewModel(
    private val saveLocalUserUseCase: SaveLocalUserUseCase,
    private val loadLocalUserUseCase: LoadLocalUserUseCase
) : ViewModel() {

    private val checkResultsLive = MutableLiveData<RegistrationResult>()
    private val userLive = MutableLiveData<User>()
    private val isRegistrationSuccessfulLive = MutableLiveData<Boolean>()
    val checkResults: LiveData<RegistrationResult> = checkResultsLive
    val user: LiveData<User> = userLive
    val isRegistrationSuccessful: LiveData<Boolean> = isRegistrationSuccessfulLive

    private fun isResultsOk(result: RegistrationResult): Boolean {
        return (result.isNameCorrect &&
                result.isSurnameCorrect &&
                result.isPasswordCorrect &&
                result.isPasswordRepeatCorrect &&
                result.birthDate == BirthDateCheckResult.OK)
    }

    fun register(registrationData: RegistrationData) {
        val validator = ValidateUseCase()
        checkResultsLive.value = validator.execute(registrationData)
        isRegistrationSuccessfulLive.value = isResultsOk(checkResultsLive.value!!)

        if (isRegistrationSuccessfulLive.value!!)
            saveData(registrationData)
    }

    private fun saveData(data: RegistrationData) {
        saveLocalUserUseCase.execute(RegistrationDataToUser().execute(data))
    }

    fun loadUser() {
        userLive.value = loadLocalUserUseCase.execute()
    }
}