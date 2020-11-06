package com.example.shopping.feature.store.fragment

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.data.ReviewData
import com.example.shopping.data.menu.MenuFragListViewData

class StoreReviewRvViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    val nickname : TextView = view.findViewById(R.id.txtFragReviewNickname)
    val rating : RatingBar = view.findViewById(R.id.rbFragReview)
    val review : TextView = view.findViewById(R.id.tvFragReview)

    fun bind(data : ReviewData) {
        nickname.text = data.nickname
        review.text = data.review
        rating.rating = data.rating.toFloat()
    }
}