package com.example.shopping.api

import android.util.Log
import com.example.shopping.R
import com.example.shopping.data.RecRvData
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.data.main.MainRvData
import com.example.shopping.data.menu.MenuFragListViewData
import com.example.shopping.data.menu.MenuTabLayoutData
import java.util.*

// TODO 서버에서 받아오는 데이터로 변환
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
            MainGridViewData(R.drawable.jacket_m, "Outer"),
            MainGridViewData(R.drawable.top_m, "Top"),
            MainGridViewData(R.drawable.dress_m, "Dress"),
            MainGridViewData(R.drawable.jeans_m, "Pants"),
            MainGridViewData(R.drawable.skirt_m, "Skirt"),
            MainGridViewData(R.drawable.shoes_m, "Shoes"),
            MainGridViewData(R.drawable.bag_m, "Bag")
        )
    }

    fun getMainRvData() : List<MainRvData> {
        return listOf(
            MainRvData(R.drawable.main_rec_1, "Outer", "black leather jacket"),
            MainRvData(R.drawable.main_rec_3, "Top", "light blue top"),
            MainRvData(R.drawable.main_rec_4, "Outer", "hood zip-up"),
            MainRvData(R.drawable.main_rec_2, "Top", "basic long sleeve t-shirt"),
            MainRvData(R.drawable.main_rec_5, "Dress", "green silk dress"),
            )
    }

    fun getMenuTabData() : List<MenuTabLayoutData> {
        return listOf(
                MenuTabLayoutData(R.drawable.menu_tab_outer_selecter, "아우터"),
                MenuTabLayoutData(R.drawable.menu_tab_top_selecter, "상의"),
                MenuTabLayoutData(R.drawable.menu_tab_dress_selecter, "원피스"),
                MenuTabLayoutData(R.drawable.menu_tab_jeans_selecter, "바지"),
                MenuTabLayoutData(R.drawable.menu_tab_skirt_selecter, "스커트"),
                MenuTabLayoutData(R.drawable.menu_tab_shoes_selecter, "슈즈"),
                MenuTabLayoutData(R.drawable.menu_tab_bag_selecter, "가방"),
                )
    }

    fun getMenuFragListViewData(sort : String) : List<MenuFragListViewData> {
        var list = mutableListOf<MenuFragListViewData>()

        when(sort) {
            "아우터" -> {
                for (i in 0..9) {
                    list.add(MenuFragListViewData(R.drawable.jacket, "${sort}$i", (100 + i).toString() + "원"))
                }
            }
            "상의" -> {
                for (i in 0..13) {
                    list.add(MenuFragListViewData(R.drawable.top, "${sort}$i", (200 + i).toString() + "원"))
                }
            }
            "원피스" -> {
                for (i in 0..18) {
                    list.add(MenuFragListViewData(R.drawable.dress, "${sort}$i", (300 + i).toString() + "원"))
                }
            }
            "바지" -> {
                for (i in 0..3) {
                    list.add(MenuFragListViewData(R.drawable.jeans, "${sort}$i", (400 + i).toString() + "원"))
                }
            }
            "스커트" -> {
                for (i in 0..20) {
                    list.add(MenuFragListViewData(R.drawable.skirt_list, "${sort}$i", (500 + i).toString() + "원"))
                }
            }
            "슈즈" -> {
                for (i in 0..5) {
                    list.add(MenuFragListViewData(R.drawable.shoes, "${sort}$i", (600 + i).toString() + "원"))
                }
            }
            else -> { // 가방
                for (i in 0..5) {
                    list.add(MenuFragListViewData(R.drawable.bag, "${sort}$i", (700 + i).toString() + "원"))
                }
            }
        }

        return list
    }

    fun getStoreVpData() : List<Int> {
        return listOf(
                R.drawable.jacket,
                R.drawable.jacket_b,
                R.drawable.jacket_m,
                R.drawable.jecket_c
                )
    }

    fun getRecRvData() : List<RecRvData> {
        return listOf(
            RecRvData("Winter Clothes", R.drawable.main_vp_1),
            RecRvData("Season Off 30 ~ 40% Sale", R.drawable.main_vp_2),
            RecRvData("Cashmere Muffler", R.drawable.main_vp_3),
        )
    }
}