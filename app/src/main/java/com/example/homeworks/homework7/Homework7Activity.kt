package com.example.homeworks.homework7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homeworks.databinding.ActivityMain7Binding

class Homework7Activity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private var timer: Int = 10
        private var checker: Boolean = false // Для проверки, пока таймер не 0
        private const val COUNTER_KEY = "COUNTER_KEY"
    }

    private lateinit var binding: ActivityMain7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var checker: Boolean = false
        val justButton = binding.justButton
        val justTimer = binding.justTimer

        justTimer.text = timer.toString()
        justButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val justTimer = binding.justTimer
        val login = binding.login
        val password = binding.password
        if (timer != 0) {
            timer--
            justTimer.text = timer.toString()
            checker = true
        }
        else if (timer == 0 && checker) {
            val justButton = binding.justButton
            justTimer.visibility  = View.GONE
            binding.loginLayout.visibility  = View.VISIBLE
            binding.passwordLayout.visibility  = View.VISIBLE
            justButton.text = "Войти"
            checker = false
        }
        else {
            if (!validateLogin() or !validatePassword()) {
                return
            }
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.LOGIN, login.text.toString())
            intent.putExtra(SecondActivity.PASSWORD, password.text.toString())
            startActivity(intent)
        }
    }

    private fun validateLogin(): Boolean {
        val emailInput = binding.login.text.toString().trim()
        if (emailInput.isEmpty()) {
            binding.loginLayout.error = "Field cant be empty"
            return false
        }
        if (emailInput.length > 20) {
            binding.loginLayout.error = "Its too long"
            return false
        }
        else {
            binding.loginLayout.error = null
            return true
        }
    }

    private fun validatePassword(): Boolean {
        val passwordInput = binding.password.text.toString().trim()
        if (passwordInput.isEmpty()) {
            binding.passwordLayout.error = "Field cant be empty"
            return false
        }
        else {
            binding.passwordLayout.error = null
            return true
        }
    }

    override fun onResume() {
        super.onResume()
        binding.justTimer.text = timer.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER_KEY, timer)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        timer = savedInstanceState.getInt(COUNTER_KEY)
    }
}