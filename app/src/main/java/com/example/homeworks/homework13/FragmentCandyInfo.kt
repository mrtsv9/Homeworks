package com.example.homeworks.homework13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homeworks.databinding.FragmentCandyInfoBinding
import com.example.homeworks.homework10.CandyItem
import java.io.Serializable

class FragmentCandyInfo : Fragment() {

    private var binding: FragmentCandyInfoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCandyInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val candy = arguments?.getSerializable(KEY_CANDY) as CandyItem
        binding?.let {
            it?.tvBrandNameFragment.text = candy.brandName
            it?.tvBarcodeFragment.text = candy.barcode.toString()
            it?.tvNumberFragment.text = candy.number.toString()
            Glide.with(it?.ivBrandIcon)
                .load(candy.imageResource)
                .into(it?.ivBrandIcon)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val KEY_CANDY = "KEY_CANDY"

        fun newInstance(candy: CandyItem) : FragmentCandyInfo = FragmentCandyInfo().apply {
            val bundle = Bundle()
            bundle.putSerializable(KEY_CANDY, candy)
            this.arguments = bundle
        }
    }
}