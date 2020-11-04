package com.example.shopping.feature.main.hot

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.api.Service
import com.example.shopping.data.main.MainRvData

class MainHotRvAdapter(private val context : Context) : RecyclerView.Adapter<MainHotRvVH>() {
    val data = Service.getMainRvData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHotRvVH {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_frag_main_item, null)
        return MainHotRvVH(view)
    }

    override fun onBindViewHolder(holder: MainHotRvVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}