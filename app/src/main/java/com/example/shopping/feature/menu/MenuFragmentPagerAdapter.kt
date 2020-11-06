package com.example.shopping.feature.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.shopping.feature.menu.fragment.*
import com.example.shopping.feature.menu.fragment.outer.MenuOuterFragment

class MenuFragmentPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 7
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                MenuOuterFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "Coat")
                    }
                }
            }
            1 -> {
                MenuTopFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "Top")
                    }
                }
            }
            2 -> {
                MenuDressFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "Dress")
                    }
                }
            }
            3 -> {
                MenuJeansFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "Pants")
                    }
                }
            }
            4 -> {
                MenuSkirtFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "Skirt")
                    }
                }
            }
            5 -> {
                MenuShoesFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "Shoes")
                    }
                }
            }
            else -> {
                MenuBagFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "Bag")
                    }
                }
            }
        }
    }
}