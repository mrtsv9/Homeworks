package com.example.homeworks.homework13

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworks.R
import com.example.homeworks.homework10.CandyItem

class CandyFragmentAdapter(
    private val candyList: MutableList<CandyItem>,
    private val clickListener: (CandyItem) -> Unit
) : RecyclerView.Adapter<CandyFragmentAdapter.CandyFragmentViewHolder>() {


    override fun getItemCount(): Int = candyList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandyFragmentViewHolder =
        CandyFragmentViewHolder(
        LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_rv_item, parent, false),
                clickListener
        )

    override fun onBindViewHolder(holder: CandyFragmentViewHolder, position: Int) {
        holder.bind(candyList[position])
    }

    class CandyFragmentViewHolder(
        itemView: View,
        private val clickListener: (CandyItem) -> Unit
        ) : RecyclerView.ViewHolder(itemView) {
        private val tvBarcode: TextView = itemView.findViewById(R.id.fragment_barcode)

        fun bind (item: CandyItem) {
            itemView.setOnClickListener { clickListener(item) }
            tvBarcode.text = item.barcode
        }
    }

    fun update(List: List<CandyItem>){
        candyList.clear()
        candyList.addAll(List)
        notifyDataSetChanged()
    }

}