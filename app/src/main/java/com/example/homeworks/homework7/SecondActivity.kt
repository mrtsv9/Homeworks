package com.example.homeworks.homework7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.homeworks.R
import homework2.MainActivity

class SecondActivity : AppCompatActivity() {

    companion object {
        const val LOGIN: String = "default"
        const val PASSWORD: String = "default"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val justLogin: TextView = findViewById(R.id.login)
        val justPassword: TextView = findViewById(R.id.password)
        var login = intent.getStringExtra(LOGIN)
        var password = intent.getStringExtra(PASSWORD)
        justLogin.text = "Логин: $login"
        justPassword.text = "Пароль: $password"
    }


}