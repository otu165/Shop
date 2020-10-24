package com.example.shopping.feature.menu

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.shopping.feature.menu.fragment.MenuDressFragment
import com.example.shopping.feature.menu.fragment.MenuOuterFragment
import com.example.shopping.feature.menu.fragment.MenuTopFragment

class MenuFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                MenuOuterFragment()
            }
            1 -> {
                MenuTopFragment()
            }
            else -> {
                MenuDressFragment()
            }
        }
    }
}