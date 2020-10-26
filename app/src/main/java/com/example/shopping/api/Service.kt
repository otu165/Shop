package com.example.shopping.api

import android.util.Log
import com.example.shopping.R
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.data.menu.MenuFragListViewData
import com.example.shopping.data.menu.MenuTabLayoutData
import java.util.*

// TODO 서버에서 받아오는 데이터로 변환
object Service {
    // ERROR 해상도 깨짐, 큰 사이즈의 이미지로 교체
    fun getMainViewPagerData() : List<Int> {
        return listOf(
                R.drawable.store_1,
                R.drawable.store_2,
                R.drawable.store_3,
                R.drawable.store_4,
                R.drawable.store_5,
        )
    }

    fun getMainGridViewData() : List<MainGridViewData> {
        return listOf<MainGridViewData>(
            MainGridViewData(R.drawable.jacket_m, "아우터"),
            MainGridViewData(R.drawable.top_m, "상의"),
            MainGridViewData(R.drawable.dress_m, "원피스/세트"),
            MainGridViewData(R.drawable.jeans_m, "바지"),
            MainGridViewData(R.drawable.skirt_m, "스커트"),
            MainGridViewData(R.drawable.shoes_m, "슈즈"),
            MainGridViewData(R.drawable.bag_m, "가방"),
        )
    }

    fun getMenuTabData() : List<MenuTabLayoutData> {
        return listOf(
                MenuTabLayoutData(R.drawable.menu_tab_outer_selecter, "아우터"),
                MenuTabLayoutData(R.drawable.menu_tab_top_selecter, "상의"),
                MenuTabLayoutData(R.drawable.menu_tab_dress_selecter, "원피스/세트"),
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
            "원피스/세트" -> {
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

    fun getRecVpData() : List<Int> {
        return listOf(
            R.drawable.jacket_m,
            R.drawable.jecket_c,
            R.drawable.jacket
        )
    }

    fun getRecRvData() : List<String> {
        return listOf(
            "아우터",
            "상의",
            "바지"
        )
    }
}