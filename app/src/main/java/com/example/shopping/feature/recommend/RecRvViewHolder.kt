package com.example.shopping.feature.recommend

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.shopping.R
import com.example.shopping.data.RecRvData

class RecRvViewHolder (view : View) : RecyclerView.ViewHolder(view) {
    val view : View = view
    val txt : TextView = view.findViewById(R.id.txtRvFragRecItem)
    val imageView : ImageView = view.findViewById(R.id.vpRvFragRecItem)

    fun bind(data : RecRvData) {
        txt.text = "# " + data.title
        Glide.with(view).load(data.image).transform(RoundedCorners(16)).into(imageView)
        imageView.clipToOutline = true
    }
}