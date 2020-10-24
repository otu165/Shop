package com.example.shopping.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.shopping.R
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.feature.menu.MenuActivity
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
        // TODO 충분한 높이를 지정해주지 않으면 전체가 출력되지 않는 문제 해결必
        val gridViewAdapter = MainGridViewAdapter(this)
        gridViewMain.adapter = gridViewAdapter

        // GridView click event
        gridViewMain.setOnItemClickListener { adapterView, view, position, l ->
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}