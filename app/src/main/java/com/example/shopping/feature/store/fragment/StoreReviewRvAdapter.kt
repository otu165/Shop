package com.example.shopping.feature.store.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.data.menu.MenuFragListViewData

class StoreReviewRvAdapter(private val context : Context) : RecyclerView.Adapter<StoreReviewRvViewHolder>() {
    val data = listOf<MenuFragListViewData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreReviewRvViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.item_frag_menu, null)
        return StoreReviewRvViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreReviewRvViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}