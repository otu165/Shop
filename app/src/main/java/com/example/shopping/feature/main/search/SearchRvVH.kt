package com.example.shopping.feature.main.search

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import kotlinx.android.synthetic.main.rv_frag_search_item.view.*

class SearchRvVH(view : View) : RecyclerView.ViewHolder(view) {
    val view : View = view
    val textView : TextView = view.findViewById(R.id.txtFragSearchRvItem)

    fun bind(data : String) {
        textView.text = data

        view.setOnClickListener {
            // TODO 해당 아이템의 StoreActivity 로 넘어가도록 설정
            // TODO 키보드 닫기

            Toast.makeText(view.context, "sorry, not available now", Toast.LENGTH_SHORT).show()
        }
    }
}