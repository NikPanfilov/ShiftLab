package com.example.shiftlab.presentation.signupScreen

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.widget.EditText
import com.example.shiftlab.R
import com.example.shiftlab.databinding.ActivityMainBinding
import com.example.shiftlab.domain.model.BirthDateCheckResult
import com.example.shiftlab.domain.model.RegistrationResult

class UIHelper(private val binding: ActivityMainBinding) {
    fun clearTextViews() {
        binding.textViewName.text = ""
        binding.textViewSurname.text = ""
        binding.textViewDate.text = ""
        binding.textViewPassword.text = ""
        binding.textViewPasswordRepeat.text = ""
    }

    fun setCheckResults(result: RegistrationResult, context: Context) {
        if (!result.isNameCorrect)
            binding.textViewName.text = context.getString(R.string.invalid_name)
        if (!result.isSurnameCorrect)
            binding.textViewSurname.text = context.getString(R.string.invalid_surname)
        if (result.birthDate == BirthDateCheckResult.INVALID_DATE_FORMAT)
            binding.textViewDate.text = context.getString(R.string.invalid_date_format)
        if (result.birthDate == BirthDateCheckResult.INVALID_DATE)
            binding.textViewDate.text = context.getString(R.string.invalid_date)
        if (!result.isPasswordCorrect)
            binding.textViewPassword.text = context.getString(R.string.invalid_password)
        if (!result.isPasswordRepeatCorrect)
            binding.textViewPasswordRepeat.text = context.getString(R.string.different_passwords)
    }

    fun checkFieldsFilled(editTextList: List<EditText>) {
        binding.buttonSignUp.setBackgroundColor(Color.GRAY)
        for (editText in editTextList) {
            if (editText.text.isEmpty()) {
                binding.buttonSignUp.isClickable = false
                return
            }
        }
        if (binding.editTextPassword.length() < 8 ||
            binding.editTextPasswordRepeat.length() < 8
        ) {
            binding.buttonSignUp.isClickable = false
            return
        }

        binding.buttonSignUp.setBackgroundColor(Color.BLUE)
        binding.buttonSignUp.isClickable = true
    }

    fun showDataPicker(context: Context) {
        binding.editTextDate.text.clear()
        val d = DatePickerDialog(context)
        d.setOnDateSetListener { _, year, month, day ->
            var date = ""
            if (day < 10)
                date = "0"
            date += "$day."
            if (month + 1 < 10)
                date += "0"
            date += (month + 1).toString() + ".$year"
            binding.editTextDate.setText(date)
        }
        d.show()
    }
}