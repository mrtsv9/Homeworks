package com.example.homeworks.homework10

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CandyViewModel : ViewModel() {

    val candiesLiveData: LiveData<List<CandyItem>> by lazy {
        MutableLiveData(CandiesFactory.generateCandies())
    }

}