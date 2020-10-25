package com.example.shopping.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.feature.menu.MenuActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var backKeyPressed : Long = 0

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
        // ERROR 충분한 높이를 지정해주지 않으면 전체가 출력되지 않는 문제
        val gridViewAdapter = MainGridViewAdapter(this)
        gridViewMain.adapter = gridViewAdapter

        // GridView click event
        gridViewMain.setOnItemClickListener { adapterView, view, position, l ->
            // TODO position 에 따라, intent 후 tab 강조를 줄 것
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

        }
    }

    override fun onBackPressed() {
        val toast : Toast = Toast.makeText(this, "\'뒤로\'버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)

        if(System.currentTimeMillis() > backKeyPressed + 2000) {
            backKeyPressed = System.currentTimeMillis()
            toast.show()
        } else if (System.currentTimeMillis() <= backKeyPressed + 2000) {
            this.finish()
            toast.cancel()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}