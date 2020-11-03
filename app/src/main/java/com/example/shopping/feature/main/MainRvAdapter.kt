package com.example.shopping.feature.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.api.Service

class MainRvAdapter(private val context : Context) : RecyclerView.Adapter<MainRvVH>() {
    val data = Service.getMainGridViewData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvVH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main_grid_view, null)
        return MainRvVH(view)
    }

    override fun onBindViewHolder(holder: MainRvVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}