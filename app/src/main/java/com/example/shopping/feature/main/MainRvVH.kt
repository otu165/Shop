package com.example.shopping.feature.main

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.feature.menu.MenuActivity

class MainRvVH(view : View) : RecyclerView.ViewHolder(view) {
    val view : View = view.findViewById(R.id.linearItemMainRecyclerView)

    val image : ImageView = view.findViewById(R.id.imgItemMainGridView)
    val text : TextView = view.findViewById(R.id.txtItemMainGridViewName)

    fun bind(data : MainGridViewData) {
        image.setImageResource(data.resource)
        text.text = data.name

        // click event
        view.setOnClickListener {
            // TODO 선택한 아이템 데이터 넘기기
            val intent = Intent(view.context, MenuActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}