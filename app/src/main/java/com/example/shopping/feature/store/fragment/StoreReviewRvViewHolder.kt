package com.example.shopping.feature.store.fragment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.data.menu.MenuFragListViewData

class StoreReviewRvViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val imageView : ImageView = view.findViewById(R.id.imgItemFragMenu)
    val textViewId : TextView = view.findViewById(R.id.txtItemFragMenu)
    val textViewRate : TextView = view.findViewById(R.id.txtItemFragMenuCost)

    fun bind(data : MenuFragListViewData) {
        textViewId.text = data.name
        textViewRate.text = data.cost
    }
}