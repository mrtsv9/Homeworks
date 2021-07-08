package com.example.homeworks.homework10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworks.databinding.ActivityRecyclerViewBinding

class CandiesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myViewModel = ViewModelProvider(this).get(CandyViewModel::class.java)

        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val candyAdapter = CandyAdapter(mutableListOf())

        binding.rvView?.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        binding.rvView?.adapter = candyAdapter
        myViewModel.candiesLiveData.observe(this, Observer {
            candyAdapter.update(it)
        })
    }

}