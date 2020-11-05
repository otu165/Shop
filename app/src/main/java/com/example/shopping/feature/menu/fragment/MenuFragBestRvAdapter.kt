package com.example.shopping.feature.menu.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.api.Service

class MenuFragBestRvAdapter(private val context : Context, sort : String) : RecyclerView.Adapter<MenuFragBestRvVH>() {
    var data = Service.getBestItem(sort)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuFragBestRvVH {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_frag_menu_outer_item, null)
        return MenuFragBestRvVH(view)
    }

    override fun onBindViewHolder(holder: MenuFragBestRvVH, position: Int) {
        holder.bind(position, data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}