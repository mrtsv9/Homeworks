package com.example.homeworks.homework13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homeworks.databinding.ActivityFragmentBinding
import com.example.homeworks.homework10.CandyItem
import com.example.homeworks.homework13.SharedPrefsKeys.PREFS_BRAND_BARCODE
import com.example.homeworks.homework13.SharedPrefsKeys.PREFS_BRAND_NAME
import com.example.homeworks.homework13.SharedPrefsKeys.PREFS_KEY

class CandyFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SharedPrefsUtils.sharedPrefs = getSharedPreferences(PREFS_KEY, MODE_PRIVATE)
        showFragment()
        showToast()
    }

    private fun showFragment() {
        val fragment = CandyFragment()
        supportFragmentManager.beginTransaction()
            .add(binding.container.id, fragment, TAG)
            .addToBackStack(null)
            .commit()
    }

    fun replaceFragment(candy: CandyItem) {
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, FragmentCandyInfo.newInstance(candy), DESCRIPTION_TAG)
            .addToBackStack(null)
            .commit()
    }

    private fun showToast() {
        val message = SharedPrefsUtils.getString(PREFS_BRAND_NAME) + " " +
                SharedPrefsUtils.getInt(PREFS_BRAND_BARCODE)
        Toast.makeText(this,
            message,
            Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "FRAGMENT"
        private const val DESCRIPTION_TAG = "DESCRIPTION_FRAGMENT"
    }

}