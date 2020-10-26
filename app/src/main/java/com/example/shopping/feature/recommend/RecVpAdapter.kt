package com.example.shopping.feature.recommend

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.shopping.R
import com.example.shopping.api.Service

class RecVpAdapter (private val context : Context) : PagerAdapter() {
    val data = Service.getRecVpData()

    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View

        viewPager.removeView(view)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view : View = layoutInflater.inflate(R.layout.vp_rv_frag_rec_item, null)

        view.findViewById<ImageView>(R.id.imgVpRvFrag).setImageResource(data[position])

        val viewPager = container as ViewPager
        viewPager.addView(view, 0)

        return view
    }
}