package com.example.homeworks.homework7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.homeworks.R
import kotlin.math.log

class Main : AppCompatActivity(), View.OnClickListener {
    companion object {
        var timer: Int = 10
        var checker: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        var checker: Boolean = false
        val justButton: Button = findViewById(R.id.justButton)
        val justTimer: TextView = findViewById(R.id.justTimer)

        justTimer.text = timer.toString()

        justButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val justTimer: TextView = findViewById(R.id.justTimer)
        val login: TextView = findViewById(R.id.login)
        val password: TextView = findViewById(R.id.password)
        if (timer != 0) {
            timer--
            justTimer.text = timer.toString()
            checker = true
        }
        else if (timer == 0 && checker) {
            val justButton: TextView = findViewById(R.id.justButton)
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
}