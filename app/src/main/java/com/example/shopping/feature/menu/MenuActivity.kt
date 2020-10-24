package com.example.shopping.feature.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.shopping.R
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
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("아우터")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("상의")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("원피스/세트")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("바지")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("스커트")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("슈즈")))
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setCustomView(getTabView("가방")))

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