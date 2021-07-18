package com.example.homeworks.homework10

import kotlin.random.Random

object CandiesFactory {

    private val map = mapOf(
        "snickers" to
                "https://dostavka.dixy.ru/upload/iblock/523/52390d34c79e45882c158e5704ec5021.jpg",
        "bounty" to
                "https://wallsdesk.com/wp-content/uploads/2017/01/Pictures-of-Bounty-.jpg",
        "kitkat" to
                "https://main-cdn.goods.ru/big1/hlr-system/-1/22/35/76/16/25/19/100024250617b0.jpeg")

    fun generateBarcode(from: Int = 10000000, to: Int = 99999999): String =
        Random.nextInt(from, to).toString()

    fun generateCandies(size: Int = 300) : ArrayList<CandyItem> {
        val list = ArrayList<CandyItem>()
        for (i in 0 until size) {

            if (i < 100) {
                val drawable = map["snickers"]
                val name = "Snickers"
                val barcode = generateBarcode()
                val item = CandyItem(drawable, name, barcode, i+1)
                list += item
            }
            else if (i < 200) {
                val drawable = map["bounty"]
                val name = "Bounty"
                val barcode = generateBarcode()
                val item = CandyItem(drawable, name, barcode, i+1)
                list += item
            }
            else {
                val drawable = map["kitkat"]
                val name = "Kit-kat"
                val barcode = generateBarcode()
                val item = CandyItem(drawable, name, barcode, i+1)
                list += item

            }
        }
        return list
    }
}