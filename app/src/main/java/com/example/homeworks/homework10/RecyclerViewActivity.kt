package com.example.homeworks.homework10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworks.R
import com.example.homeworks.databinding.ActivityRecyclerViewBinding
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val candyAdapter = CandyAdapter(generateList())

        binding.rvView?.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        binding.rvView?.adapter = candyAdapter
    }

    private fun generateList(size: Int = 300): ArrayList<CandyItem> {
        val list = ArrayList<CandyItem>()
        for (i in 0 until size) {

                if (i < 100) {
                    val drawable = R.drawable.snikers
                    val name = "Snickers"
                    val barcode = generateBarcode()
                    val item = CandyItem(drawable, name, barcode, i+1)
                    list += item
                }
                else if (i < 200) {
                    val drawable = R.drawable.bounty
                    val name = "Bounty"
                    val barcode = generateBarcode()
                    val item = CandyItem(drawable, name, barcode, i+1)
                    list += item
                }
                else {
                    val drawable = R.drawable.kitkat
                    val name = "Kit-kat"
                    val barcode = generateBarcode()
                    val item = CandyItem(drawable, name, barcode, i+1)
                    list += item

            }
        }
        return list
    }

    private fun generateBarcode(from: Int = 10000000, to: Int = 99999999): String =
        Random.nextInt(from, to).toString()
}