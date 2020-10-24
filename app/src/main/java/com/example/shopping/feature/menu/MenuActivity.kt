package com.example.shopping.feature.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.shopping.R
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
        // TODO 서버에 데이터 저장 후 반복문으로 해결
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("아우터")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("상의")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("원피스/세트")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("바지")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("스커트")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("슈즈")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("가방")))

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
    private fun getTabView(element : String) : View {
        val view : View = LayoutInflater.from(this).inflate(R.layout.item_tab_layout_menu, null)

        view.findViewById<ImageView>(R.id.imgItemTab).setImageResource(R.drawable.ic_baseline_crop_original_24)
        view.findViewById<TextView>(R.id.txtItemTab).text = element

        return view;
    }

    companion object {
        private const val TAG = "MenuActivity"
    }
}