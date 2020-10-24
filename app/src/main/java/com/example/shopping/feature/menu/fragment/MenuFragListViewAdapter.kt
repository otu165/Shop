package com.example.shopping.feature.menu.fragment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.shopping.R
import com.example.shopping.api.Service

class MenuFragListViewAdapter(private val context : Context,
                              private val sort : String) : BaseAdapter() {
    private var data = Service.getMenuFragListViewData(sort)

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.item_frag_menu, null)

        view.findViewById<ImageView>(R.id.imgItemFragMenu).setImageResource(data[p0].imageResource)
        view.findViewById<TextView>(R.id.txtItemFragMenu).text = data[p0].name
        view.findViewById<TextView>(R.id.txtItemFragMenuCost).text = data[p0].cost

        return view
    }

}