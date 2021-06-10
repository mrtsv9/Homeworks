package com.example.homeworks.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.homeworks.R
import com.example.homeworks.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val LOGIN: String = "LOGIN"
        const val PASSWORD: String = "PASSWORD"
    }

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val justLogin = binding.login
        val justPassword = binding.password
        var login = intent.getStringExtra(LOGIN)
        var password = intent.getStringExtra(PASSWORD)
        justLogin.text = "Логин: $login"
        justPassword.text = "Пароль: $password"
        var button = binding.button
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        finish()
    }


}