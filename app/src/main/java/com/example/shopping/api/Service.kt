package com.example.shopping.api

import com.example.shopping.R
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.data.menu.MenuFragListViewData

// TODO 서버에서 받아오는 데이터로 변환
object Service {
    fun getMainGridViewData() : List<MainGridViewData> {
        return listOf<MainGridViewData>(
            MainGridViewData(R.drawable.cloth_1, "옷", 10000),
            MainGridViewData(R.drawable.cloth_2, "옷", 5000),
            MainGridViewData(R.drawable.cloth_3, "옷", 28000),
            MainGridViewData(R.drawable.hat_1, "모자", 8000),
            MainGridViewData(R.drawable.hat_2, "모자", 7000),
            MainGridViewData(R.drawable.mitten_1, "벙어리 장갑", 12000),
            MainGridViewData(R.drawable.sock_1, "양말", 2500),
        )
    }

    fun getMenuFragListViewData() : List<MenuFragListViewData> {
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