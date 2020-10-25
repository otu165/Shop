package com.example.shopping.feature.store

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.shopping.R
import com.example.shopping.api.Service
import kotlinx.android.synthetic.main.activity_store.view.*
import kotlinx.android.synthetic.main.vp_store_item.view.*

class StoreVpAdapter (private val context : Context) : PagerAdapter() {
    var data = Service.getStoreVpData()

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
        val view : View = layoutInflater.inflate(R.layout.vp_store_item, null)

        view.imgVpStoreItem.setImageResource(data[position])

        val viewPager = container as ViewPager
        viewPager.addView(view)

        return view
    }
}
