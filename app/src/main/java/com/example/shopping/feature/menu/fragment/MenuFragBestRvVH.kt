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

class MenuFragBestRvVH(view : View) : RecyclerView.ViewHolder(view) {
    val view : View = view

    val txtGrade : TextView = view.findViewById(R.id.txtFragOuterGrade)
    val img : ImageView = view.findViewById(R.id.imgFragOuter)

    val txtName : TextView = view.findViewById(R.id.txtFragOuterName)
    val txtInfo : TextView = view.findViewById(R.id.txtFragOuterInfo)
    val txtCost : TextView = view.findViewById(R.id.txtFragOuterCost)

    fun bind(num : Int, data : MenuFragListViewData) {
        txtGrade.text = (num + 1).toString()
        Glide.with(view).load(data.imageResource).into(img)
        txtName.text = data.name
        txtInfo.text = data.info
        txtCost.text = data.cost

        // click event
        view.setOnClickListener {
            val menu = SelectedMenu(data.name, data.info, data.cost, data.imageResource.toString())

            val intent = Intent(view.context, StoreActivity::class.java)
                .putExtra("item", menu)
            view.context.startActivity(intent)
        }
    }
}