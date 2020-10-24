package com.example.shopping.feature.menu

import android.content.Context
import android.os.Bundle
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
                MenuOuterFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "아우터")
                    }
                }
            }
            1 -> {
                MenuTopFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "상의")
                    }
                }
            }
            2 -> {
                MenuDressFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "원피스/세트")
                    }
                }
            }
            3 -> {
                MenuJeansFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "바지")
                    }
                }
            }
            4 -> {
                MenuSkirtFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "스커트")
                    }
                }
            }
            5 -> {
                MenuShoesFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "슈즈")
                    }
                }
            }
            else -> {
                MenuBagFragment().apply {
                    arguments = Bundle().apply {
                        putString("KEY", "가방")
                    }
                }
            }
        }
    }
}