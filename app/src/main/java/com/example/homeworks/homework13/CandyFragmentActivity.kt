package com.example.homeworks.homework13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworks.databinding.ActivityFragmentBinding
import com.example.homeworks.homework10.CandyItem

class CandyFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment()
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

    companion object {
        private const val TAG = "FRAGMENT"
        private const val DESCRIPTION_TAG = "DESCRIPTION_FRAGMENT"
    }

}