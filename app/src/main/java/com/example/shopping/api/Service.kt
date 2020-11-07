package com.example.shopping.api

import android.util.Log
import com.example.shopping.R
import com.example.shopping.data.RecRvData
import com.example.shopping.data.ReviewData
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.data.main.MainRvData
import com.example.shopping.data.menu.MenuFragListViewData
import com.example.shopping.data.menu.MenuTabLayoutData
import java.util.*

// TODO 서버에서 받아오는 데이터로 변환
// TODO drawable 정리

object Service {

    fun getMainViewPagerData() : List<Int> {
        return listOf(
                R.drawable.main_vp_1,
                R.drawable.main_vp_2,
                R.drawable.main_vp_3,
                R.drawable.main_vp_4,
                R.drawable.main_vp_5,
        )
    }

    fun getMainGridViewData() : List<MainGridViewData> {
        return listOf(
            MainGridViewData(R.drawable.main_c_jacket, "Coat"),
            MainGridViewData(R.drawable.main_c_top, "Top"),
            MainGridViewData(R.drawable.main_c_dress, "Dress"),
            MainGridViewData(R.drawable.main_c_pants, "Pants"),
            MainGridViewData(R.drawable.main_c_skirt, "Skirt"),
            MainGridViewData(R.drawable.main_c_shoes, "Shoes"),
            MainGridViewData(R.drawable.main_c_bag, "Bag"),
            MainGridViewData(R.drawable.main_c_8, "Dress")
        )
    }

    fun getMainRvData() : List<MainRvData> {
        return listOf(
            MainRvData(R.drawable.main_rec_1, "Jacket", "black leather jacket"),
            MainRvData(R.drawable.main_rec_5, "Dress", "green silk dress"),
            MainRvData(R.drawable.main_rec_2, "Top", "light blue top"),
            MainRvData(R.drawable.main_rec_3, "Hoodie", "hood zip-up"),
            MainRvData(R.drawable.main_rec_4, "Top", "basic long sleeve t-shirt")
            )
    }

    fun getMenuTabData() : List<MenuTabLayoutData> {
        return listOf(
                MenuTabLayoutData(R.drawable.jacket_b, "Coat"),
                MenuTabLayoutData(R.drawable.top_b, "Top"),
                MenuTabLayoutData(R.drawable.dress_b, "Dress"),
                MenuTabLayoutData(R.drawable.jeans_b, "Pants"),
                MenuTabLayoutData(R.drawable.skirt_b, "Skirt"),
                MenuTabLayoutData(R.drawable.shoes_b, "Shoes"),
                MenuTabLayoutData(R.drawable.bag, "Bag"),
                )
    }

    fun getMenuFragListViewData(sort : String) : List<MenuFragListViewData> {
        var list = mutableListOf<MenuFragListViewData>()

        when(sort) {
            "Coat" -> {
                for (i in 0..9) {
                    list.add(MenuFragListViewData(R.drawable.jacket_icon, "${sort}$i", "DESCRIPTION", (100 + i).toString() + "원"))
                }
            }
            "Top" -> {
                for (i in 0..13) {
                    list.add(MenuFragListViewData(R.drawable.top, "${sort}$i", "DESCRIPTION",(200 + i).toString() + "원"))
                }
            }
            "Dress" -> {
                for (i in 0..18) {
                    list.add(MenuFragListViewData(R.drawable.dress, "${sort}$i", "DESCRIPTION",(300 + i).toString() + "원"))
                }
            }
            "Pants" -> {
                for (i in 0..3) {
                    list.add(MenuFragListViewData(R.drawable.jeans, "${sort}$i", "DESCRIPTION",(400 + i).toString() + "원"))
                }
            }
            "Skirt" -> {
                for (i in 0..20) {
                    list.add(MenuFragListViewData(R.drawable.skirt_list, "${sort}$i", "DESCRIPTION",(500 + i).toString() + "원"))
                }
            }
            "Shoes" -> {
                for (i in 0..5) {
                    list.add(MenuFragListViewData(R.drawable.shoes, "${sort}$i", "DESCRIPTION",(600 + i).toString() + "원"))
                }
            }
            else -> { // Bag
                for (i in 0..5) {
                    list.add(MenuFragListViewData(R.drawable.bag, "${sort}$i", "DESCRIPTION",(700 + i).toString() + "원"))
                }
            }
        }

        return list
    }

    fun getBestItem(sort : String) : List<MenuFragListViewData> {
        var list = mutableListOf<MenuFragListViewData>()

        when(sort) {
            "Coat" -> {
                for (i in 1..4) {
                    list.add(MenuFragListViewData(R.drawable.jacket_icon, "${sort}$i", "INFORMATION", (100 + i).toString() + "원"))
                }
            }
            "Top" -> {
                for (i in 1..4) {
                    list.add(MenuFragListViewData(R.drawable.top, "${sort}$i", "INFORMATION",(200 + i).toString() + "원"))
                }
            }
            "Dress" -> {
                for (i in 1..4) {
                    list.add(MenuFragListViewData(R.drawable.dress, "${sort}$i", "INFORMATION",(300 + i).toString() + "원"))
                }
            }
            "Pants" -> {
                for (i in 1..4) {
                    list.add(MenuFragListViewData(R.drawable.jeans, "${sort}$i", "INFORMATION",(400 + i).toString() + "원"))
                }
            }
            "Skirt" -> {
                for (i in 1..4) {
                    list.add(MenuFragListViewData(R.drawable.skirt_list, "${sort}$i", "INFORMATION",(500 + i).toString() + "원"))
                }
            }
            "Shoes" -> {
                for (i in 1..4) {
                    list.add(MenuFragListViewData(R.drawable.shoes, "${sort}$i", "INFORMATION",(600 + i).toString() + "원"))
                }
            }
            else -> { // Bag
                for (i in 1..4) {
                    list.add(MenuFragListViewData(R.drawable.bag, "${sort}$i", "INFORMATION",(700 + i).toString() + "원"))
                }
            }
        }

        return list

    }

    fun getRecRvData() : List<RecRvData> {
        return listOf(
            RecRvData("Winter Clothes", R.drawable.main_vp_1),
            RecRvData("Season Off 30 ~ 40% Sale", R.drawable.main_vp_2),
            RecRvData("Cashmere Muffler", R.drawable.main_vp_3),
        )
    }
}