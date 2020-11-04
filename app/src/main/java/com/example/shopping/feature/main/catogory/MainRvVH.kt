package com.example.shopping.feature.main.catogory

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopping.R
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.feature.menu.MenuActivity

class MainRvVH(view : View) : RecyclerView.ViewHolder(view) {
    val view : View = view.findViewById(R.id.linearItemMainRecyclerView)

    val image : ImageView = view.findViewById(R.id.imgItemMainGridView)
    val text : TextView = view.findViewById(R.id.txtItemMainGridViewName)

    fun bind(data : MainGridViewData) {
        Glide.with(view).load(data.resource).override(600, 600).fitCenter().into(image)
        text.text = data.name


        // click event
        view.setOnClickListener {
            // TODO 선택한 아이템 데이터 넘기기
            val intent = Intent(view.context, MenuActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}