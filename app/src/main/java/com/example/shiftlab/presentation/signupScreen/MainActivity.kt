package com.example.shiftlab.presentation.signupScreen

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.shiftlab.databinding.ActivityMainBinding
import com.example.shiftlab.domain.model.RegistrationData
import com.example.shiftlab.presentation.mainScreen.MainScreenActivity

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val uiHelper by lazy { UIHelper(binding) }
    private val editTextList = mutableListOf<EditText>()
    private lateinit var vm: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        for (id in binding.textFields.referencedIds) {
            val editText = findViewById<EditText>(id)
            editTextList.add(editText)
            editText.doAfterTextChanged { uiHelper.checkFieldsFilled(editTextList) }
        }

        binding.buttonSignUp.isClickable = false
        binding.buttonSignUp.setBackgroundColor(Color.GRAY)

        binding.buttonSignUp.setOnClickListener { signUp() }

        binding.buttonCalendar.setOnClickListener {
            uiHelper.showDataPicker(this)
        }

        autoSignIn()
    }

    private fun signUp() {
        setFieldsAvailability(false)
        uiHelper.clearTextViews()

        vm.register(fieldsToRegistrationData())
        if (!vm.isRegistrationSuccessful.value!!) {
            uiHelper.setCheckResults(vm.checkResults.value!!, this)
            setFieldsAvailability(true)
            binding.buttonSignUp.isClickable = false
            binding.buttonSignUp.setBackgroundColor(Color.GRAY)
        } else {
            startActivity(Intent(this, MainScreenActivity::class.java))
        }
        setFieldsAvailability(true)
    }

    private fun autoSignIn() {
        vm.loadUser()
        if (vm.user.value!!.name != "")
            startActivity(Intent(this, MainScreenActivity::class.java))
    }

    private fun fieldsToRegistrationData(): RegistrationData {
        return RegistrationData(
            name = binding.editTextName.text.toString(),
            surname = binding.editTextSurname.text.toString(),
            birthDate = binding.editTextDate.text.toString(),
            password = binding.editTextPassword.text.toString(),
            passwordRepeat = binding.editTextPasswordRepeat.text.toString(),
        )
    }

    private fun setFieldsAvailability(state: Boolean) {
        for (editText in editTextList) {
            editText.isEnabled = state
        }
        binding.buttonCalendar.isEnabled = state
    }
}