package com.example.homeworks.homework10

import java.io.Serializable

data class CandyItem(
    val imageResource: String?,
    val brandName: String,
    val barcode: String,
    val number: Int) : Serializable

