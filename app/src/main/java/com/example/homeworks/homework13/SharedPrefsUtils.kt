package com.example.homeworks.homework13

import android.content.SharedPreferences

object SharedPrefsUtils {
    lateinit var sharedPrefs : SharedPreferences

    fun putInt (key: String, value: Int) {
        sharedPrefs.edit().putInt(key, value).apply()
    }

    fun putString (key: String, value: String) {
        sharedPrefs.edit().putString(key, value).apply()
    }

    fun getInt (key: String) = sharedPrefs.getInt(key,  0)

    fun getString (key: String) = sharedPrefs.getString(key, "No saved value!")

}