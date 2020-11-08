package com.example.shopping.feature.menu.fragment

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopping.R
import com.example.shopping.data.menu.MenuFragListViewData
import com.example.shopping.feature.menu.fragment.outer.SelectedMenu
import com.example.shopping.feature.store.StoreActivity
import kotlinx.android.synthetic.main.fragment_menu_outer.view.*

class MenuFragRvVH(view : View) : RecyclerView.ViewHolder(view) {
    val view : View = view

    val imageView : ImageView = view.findViewById(R.id.imgCard)
    val name : TextView = view.findViewById(R.id.txtCardName)
    val info : TextView = view.findViewById(R.id.txtCardDescription)
    val cost : TextView = view.findViewById(R.id.txtCardCost)

    fun bind(data : MenuFragListViewData) {
        imageView.setImageResource(data.imageResource)
        name.text = data.name
        info.text = data.info
        cost.text = data.cost

        val item = SelectedMenu(data.name, data.info, data.cost, data.imageResource.toString())

        // click event
        view.setOnClickListener {
            val intent = Intent(view.context, StoreActivity::class.java)
                .putExtra("item", item)
            view.context.startActivity(intent)
        }
    }
}