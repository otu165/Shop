package com.example.shopping.feature.store

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.shopping.feature.store.fragment.StoreAlertFragment
import com.example.shopping.feature.store.fragment.StoreInfoFragment
import com.example.shopping.feature.store.fragment.StoreReviewFragment

class StoreFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
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
                StoreReviewFragment()
            }
        }
    }
}