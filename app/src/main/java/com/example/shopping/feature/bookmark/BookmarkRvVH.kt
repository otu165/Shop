package com.example.shopping.feature.bookmark

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.data.menu.MenuFragListViewData

class BookmarkRvVH (view : View) : RecyclerView.ViewHolder(view) {

    val image : ImageView = view.findViewById(R.id.imgCard)
    val name : TextView = view.findViewById(R.id.txtCardName)
    val info : TextView = view.findViewById(R.id.txtCardDescription)
    val cost : TextView = view.findViewById(R.id.txtCardCost)

    fun bind(data : MenuFragListViewData) {
        image.setImageResource(data.imageResource)
        name.text = data.name
        info.text = data.info
        cost.text = data.cost
    }
}