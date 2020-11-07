package com.example.shopping.feature.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.api.Service
import com.example.shopping.data.menu.MenuTabLayoutData
import com.example.shopping.feature.menu.fragment.outer.MenuOuterFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_menu.view.*

class MenuActivity : AppCompatActivity() {
    var sort : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Log.d(TAG, "${TAG} created")
        sort = intent.getIntExtra("sort", 0)
        menuFunction()
    }

    private fun menuFunction() {
        // 2. Fragment + ViewPager
        val fragmentPagerAdapter = MenuFragmentPagerAdapter(supportFragmentManager)
        viewPagerMenu.adapter = fragmentPagerAdapter
        tabLayoutMenu.setupWithViewPager(viewPagerMenu)

        // 1. TabLayout
        var count : Int = 0
        for (list in Service.getMenuTabData()) {
            tabLayoutMenu.getTabAt(count++)?.customView = getTabView(list)
        }

        // 사용자의 drawer 클릭에 따른 tab 보여주기
        tabLayoutMenu.getTabAt(sort!!)?.select()

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