package com.example.homeworks.homework13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworks.databinding.FragmentCandiesListBinding
import com.example.homeworks.homework10.CandyItem
import com.example.homeworks.homework10.CandyViewModel
import com.example.homeworks.homework13.SharedPrefsKeys.PREFS_BRAND_BARCODE
import com.example.homeworks.homework13.SharedPrefsKeys.PREFS_BRAND_NAME

class CandyFragment() : Fragment() {

    private var binding: FragmentCandiesListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCandiesListBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myViewModel = ViewModelProvider(this).
        get(CandyViewModel::class.java)

        val candyFragmentAdapter = CandyFragmentAdapter(mutableListOf())
        { clickListener(it) }

        binding?.rvFragment?.layoutManager = LinearLayoutManager( binding?.root?.context,
            LinearLayoutManager.VERTICAL, false)
        binding?.rvFragment?.adapter = candyFragmentAdapter
        myViewModel.candiesLiveData.observe(viewLifecycleOwner, Observer {
            candyFragmentAdapter.update(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun clickListener(candy: CandyItem) {
        (activity as? CandyFragmentActivity)?.replaceFragment(candy)
        SharedPrefsUtils.putString(PREFS_BRAND_NAME, candy.brandName)
        SharedPrefsUtils.putInt(PREFS_BRAND_BARCODE, candy.barcode.toInt())
    }

}