package com.example.shopping.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.shopping.R
import com.example.shopping.data.main.MainGridViewData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "${TAG} created")
        mainFunction()
    }

    private fun mainFunction() {
        // 1. ViewPager
        val viewPagerAdapter = MainViewPagerAdapter(this)
        viewPagerMain.adapter = viewPagerAdapter

        // 2. GridView
        // TODO 높이를 지정해주지 않으면 짤려서 출력되는 문제 있음
        val gridViewAdapter = MainGridViewAdapter(this)
        gridViewMain.adapter = gridViewAdapter
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}