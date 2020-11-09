package com.example.shopping.feature.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.shopping.feature.store.fragment.StoreAlertFragment
import com.example.shopping.feature.store.fragment.StoreInfoFragment
import com.example.shopping.feature.store.fragment.StoreReviewFragment

class StoreFragmentPagerAdapter(fragmentManager: FragmentManager,
                                val name : String,
                                val image : Int) : FragmentPagerAdapter(fragmentManager) {
    val data = name

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                StoreInfoFragment()
            }
            1 -> {
                StoreAlertFragment()
            }
            else -> {
                StoreReviewFragment().apply {
                    arguments = Bundle().apply {
                        putString("name", data)
                        putInt("image", image)
                    }
                }
            }
        }
    }
}