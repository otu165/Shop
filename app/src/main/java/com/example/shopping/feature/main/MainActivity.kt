package com.example.shopping.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.shopping.R
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
        val gridViewAdapter = MainGridViewAdapter(this)
        gridViewMain.adapter = gridViewAdapter
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}