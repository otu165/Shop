package com.example.shopping.feature.recommend

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.api.Service

class RecRvAdapter (private val context : Context) : RecyclerView.Adapter<RecRvViewHolder>() {
    var data = Service.getRecRvData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecRvViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.rv_frag_recommend_item, null)
        return RecRvViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecRvViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}