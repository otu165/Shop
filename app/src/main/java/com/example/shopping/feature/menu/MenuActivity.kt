package com.example.shopping.feature.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.shopping.R
import com.example.shopping.api.Service
import com.example.shopping.data.menu.MenuTabLayoutData
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Log.d(TAG, "${TAG} created")
        menuFunction()
    }

    private fun menuFunction() {
        // 1. TabLayout
        // ERROR tab 너비 줄여야 함
        for (list in Service.getMenuTabData()) {
            tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView(list)))
        }

        tabLayoutMenu.addOnTabSelectedListener(
                object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        if(tab != null) {
                            viewPagerMenu.currentItem = tab.position
                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {
                    }

                    override fun onTabReselected(tab: TabLayout.Tab?) {
                    }

                }
        )
        // 2. Fragment + ViewPager
        val fragmentPagerAdapter = MenuFragmentPagerAdapter(supportFragmentManager)
        viewPagerMenu.adapter = fragmentPagerAdapter
        viewPagerMenu.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayoutMenu))

    }

    // compose Tab Item
    private fun getTabView(data : MenuTabLayoutData) : View {
        val view : View = LayoutInflater.from(this).inflate(R.layout.item_tab_layout_menu, null)

        view.findViewById<ImageView>(R.id.imgItemTab).setImageResource(data.imageResource)
        view.findViewById<TextView>(R.id.txtItemTab).text = data.sort

        return view;
    }

    companion object {
        private const val TAG = "MenuActivity"
    }
}