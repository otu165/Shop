package com.example.shopping.feature.main.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R

class SearchRvAdapter(private val context : Context,
                      private val clothes : List<String>) : RecyclerView.Adapter<SearchRvVH>() {

    var data = clothes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRvVH {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_frag_search_item, parent, false)
        return SearchRvVH(view)
    }

    override fun onBindViewHolder(holder: SearchRvVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}