package com.example.shopping.feature.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.api.Service
import com.example.shopping.data.main.MainGridViewData
import kotlinx.android.synthetic.main.item_main_grid_view.view.*

class MainGridViewAdapter(private val context : Context) : BaseAdapter() {
    val data = Service.getMainGridViewData()

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        Log.d("TAG", "getView() 메서드 호출" )

        val view = LayoutInflater.from(context).inflate(R.layout.item_main_grid_view, parent, false)

        // compose item view
        view.imgItemMainGridView.setImageResource(data[position].resource)
        view.txtItemMainGridViewName.setText(data[position].name)
        view.txtItemMainGridViewCost.setText(data[position].cost.toString() + "원")

        return view
    }

    companion object {
        private const val TAG = "MainGridViewAdapter"
    }

}