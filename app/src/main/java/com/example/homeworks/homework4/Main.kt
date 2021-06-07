package com.example.homeworks.homework4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homeworks.R
import homework4.Boss
import homework4.Employee
import homework4.Manager
import homework4.Worker

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val persons = PersonFactory().createPersons()
        PersonFactory().showInfo(persons)
    }

}