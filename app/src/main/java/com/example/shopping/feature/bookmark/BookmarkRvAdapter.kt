package com.example.shopping.feature.bookmark

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.data.menu.MenuFragListViewData

class BookmarkRvAdapter(private val context : Context,
                        bookmarkList : List<MenuFragListViewData>) : RecyclerView.Adapter<BookmarkRvVH>() {

    var data = bookmarkList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkRvVH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_frag_menu, parent, false)
        return BookmarkRvVH(view)
    }

    override fun onBindViewHolder(holder: BookmarkRvVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

}