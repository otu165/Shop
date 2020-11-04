package com.example.shopping.feature.menu.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.api.Service

class MenuFragRvAdapter(private val context : Context,
                        sort : String) : RecyclerView.Adapter<MenuFragRvVH>() {

    private var data = Service.getMenuFragListViewData(sort)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuFragRvVH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag_menu, null)
        return MenuFragRvVH(view)
    }

    override fun onBindViewHolder(holder: MenuFragRvVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}