package com.example.shopping.feature.menu

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.shopping.feature.menu.fragment.*

class MenuFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 7
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                MenuOuterFragment()
            }
            1 -> {
                MenuTopFragment()
            }
            2 -> {
                MenuDressFragment()
            }
            3 -> {
                MenuJeansFragment()
            }
            4 -> {
                MenuSkirtFragment()
            }
            5 -> {
                MenuShoesFragment()
            }
            else -> {
                MenuBagFragment()
            }
        }
    }
}