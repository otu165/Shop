package com.example.shopping.api

import com.example.shopping.R
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.data.menu.MenuFragListViewData
import com.example.shopping.data.menu.MenuTabLayoutData

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

    fun getMenuFragListViewOuterData() : List<MenuFragListViewData> {
        return listOf(
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터1", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터2", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터3", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터4", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터5", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터6", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터7", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터8", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터9", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터10", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터11", 100.toString() + "원"),
            MenuFragListViewData(R.drawable.ic_baseline_filter_1_24, "아우터12", 100.toString() + "원"),
        )
    }
}