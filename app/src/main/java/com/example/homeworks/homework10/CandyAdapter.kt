package com.example.homeworks.homework10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworks.R

class CandyAdapter(
    private val candyList: MutableList<CandyItem>
) : RecyclerView.Adapter<CandyAdapter.CandyViewHolder>() {

    override fun getItemCount(): Int = candyList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandyViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_rv_item, parent, false)
        return CandyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CandyViewHolder, position: Int) {
        holder.bind(candyList[position])
    }

    class CandyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvBrand: TextView = itemView.findViewById(R.id.tv_brand_name)
        val tvBarcode: TextView = itemView.findViewById(R.id.tv_barcode)
        val tvImage: ImageView = itemView.findViewById(R.id.tv_image)
        val tvNumber: TextView = itemView.findViewById(R.id.tv_number)

        fun bind(item: CandyItem) {
            tvBrand.text = item.brandName
            tvBarcode.text = item.barcode
            tvNumber.text = item.number.toString()
            Glide.with(tvImage)
                .load(item.imageResource)
                .into(tvImage)
        }
    }

    fun update(List: List<CandyItem>) {
        candyList.apply {
            clear()
            addAll(List)
            notifyDataSetChanged()
        }
    }
}