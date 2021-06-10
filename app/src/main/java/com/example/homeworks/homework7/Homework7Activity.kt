package com.example.homeworks.homework7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.homeworks.R
import com.example.homeworks.databinding.ActivityMain7Binding

class Homework7Activity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private var timer: Int = 10
        private var checker: Boolean = false
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
            login.visibility  = View.VISIBLE
            password.visibility  = View.VISIBLE
            justButton.text = "Войти"
            checker = false
        }
        else {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.LOGIN, login.text.toString())
            intent.putExtra(SecondActivity.PASSWORD, password.text.toString())
            startActivity(intent)
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