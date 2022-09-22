package com.example.shiftlab.presentation.mainScreen

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shiftlab.R
import com.example.shiftlab.databinding.ActivityMainScreenBinding

class MainScreenActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainScreenBinding.inflate(layoutInflater) }
    private lateinit var vm: MainScreenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonGreeting.setBackgroundColor(Color.GREEN)

        vm = ViewModelProvider(
            this,
            MainScreenViewModelFactory(this)
        )[MainScreenViewModel::class.java]

        vm.loadUser()
        binding.buttonGreeting.setOnClickListener {
            showMessage("${vm.user.value!!.name} ${vm.user.value!!.surname} - ты молодец, так держать!")
        }
    }

    private fun showMessage(username: String) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(getString(R.string.greeting))
        alertDialog.setMessage(username)
        alertDialog.setNeutralButton(
            getString(R.string.ok)
        ) { _, _ -> }
        alertDialog.show()
    }
}