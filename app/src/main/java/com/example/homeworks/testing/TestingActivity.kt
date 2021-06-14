package com.example.homeworks.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.homeworks.R

class TestingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)
        val image: ImageView = findViewById(R.id.image)
        Glide.with(this)
            .load("https://picsum.photos/seed/picsum/200/300")
            .into(image)
    }
}