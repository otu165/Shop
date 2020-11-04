package com.example.shopping.feature.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.shopping.R
import com.example.shopping.api.Service

class MainViewPagerAdapter(private val context : Context) : PagerAdapter() {

    // TODO 서버에서 받아오는 데이터로 변경
    private val image = Service.getMainViewPagerData()

    override fun getCount(): Int {
        return image.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    // view attach
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // make view
        val layoutInflater  = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.item_main_view_pager, null)

        // image setting
        val imageView : ImageView = view.findViewById(R.id.imgItemMainViewPager)
        Glide.with(context).load(image[position]).into(imageView)

        // viewPager setting
        val viewPager = container as ViewPager
        viewPager.addView(view, 0)

        return view
    }

    // view detach
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View

        viewPager.removeView(view)
    }
}