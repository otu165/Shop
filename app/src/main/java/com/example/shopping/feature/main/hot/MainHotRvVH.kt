package com.example.shopping.feature.main.hot

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopping.R
import com.example.shopping.data.main.MainRvData

class MainHotRvVH(view : View) : RecyclerView.ViewHolder(view) {
    private val view : View = view.findViewById(R.id.linearRvFragMain)

    private val imageView : ImageView = view.findViewById(R.id.imgRvFragMain)
    private val title : TextView = view.findViewById(R.id.txtRvFragMainName)
    private val description : TextView = view.findViewById(R.id.txtRvFragMainDescription)

    fun bind(data : MainRvData) {
        Glide.with(view).load(data.image).centerCrop().into(imageView)
        title.text = data.title
        description.text = data.description
    }
}