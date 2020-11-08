package com.example.shopping.feature.main.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.shopping.R

class SearchLvAdapter (private val context : Context, private val clothes : List<String>) : BaseAdapter() {
    var data = clothes

    override fun getCount(): Int = data.size

    override fun getItem(p0: Int): Any = data[p0]

    override fun getItemId(p0: Int): Long = 0

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_frag_search_item, null)

        view.findViewById<TextView>(R.id.txtFragSearchRvItem).text = data[p0]

        // click listener
        view.setOnClickListener {
            Toast.makeText(context, "Sorry, ${p0+1} not available now", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}