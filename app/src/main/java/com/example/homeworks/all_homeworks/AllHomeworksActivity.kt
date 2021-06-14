 package com.example.homeworks.all_homeworks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.homeworks.databinding.ActivityAllHomeworksBinding
import com.example.homeworks.homework4.Homework4Activity
import com.example.homeworks.homework6.Homework6Activity
import com.example.homeworks.homework7.Homework7Activity
import homework2.Homework2Activity
import homework3.Homework3Activity

class AllHomeworksActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAllHomeworksBinding.inflate(layoutInflater)
        val view = binding.root
        val homework2Button = binding.homework2
        val homework3Button = binding.homework3
        val homework4Button = binding.homework4
        val homework6Button = binding.homework6
        val homework7Button = binding.homework7
        setContentView(view)
        homework2Button.setOnClickListener(this)
        homework3Button.setOnClickListener(this)
        homework4Button.setOnClickListener(this)
        homework6Button.setOnClickListener(this)
        homework7Button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val binding = ActivityAllHomeworksBinding.inflate(layoutInflater)
        when (v?.id) {
            binding.homework2.id -> {
                val intent = Intent(this, Homework2Activity::class.java)
                startActivity(intent)
            }
            binding.homework3.id -> {
                val intent = Intent(this, Homework3Activity::class.java)
                startActivity(intent)
            }
            binding.homework4.id -> {
                val intent = Intent(this, Homework4Activity::class.java)
                startActivity(intent)
            }
            binding.homework6.id -> {
                val intent = Intent(this, Homework6Activity::class.java)
                startActivity(intent)
            }
            binding.homework7.id -> {
                val intent = Intent(this, Homework7Activity::class.java)
                startActivity(intent)
            }
        }
    }
}