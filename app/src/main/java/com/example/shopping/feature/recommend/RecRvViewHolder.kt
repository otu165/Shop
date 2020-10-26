package com.example.shopping.feature.recommend

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.shopping.R

class RecRvViewHolder (view : View) : RecyclerView.ViewHolder(view) {
    val view : View = view
    val txt : TextView = view.findViewById(R.id.txtRvFragRecItem)
    val vp : ViewPager = view.findViewById(R.id.vpRvFragRecItem)

    fun bind(data : String) {
        txt.text = data

//         compose ViewPager
        val vpAdapter = RecVpAdapter(view.context)
        vp.adapter = vpAdapter
    }
}