package com.example.shopping.feature.menu.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopping.R
import kotlinx.android.synthetic.main.fragment_menu_dress.*
import kotlinx.android.synthetic.main.fragment_menu_dress.view.*
import kotlinx.android.synthetic.main.fragment_menu_jeans.*
import kotlinx.android.synthetic.main.fragment_menu_jeans.view.*

class MenuJeansFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view : View = inflater.inflate(R.layout.fragment_menu_jeans, container, false)

        menuJeansFunction(view)

        Log.d(TAG, "${TAG} created")
        return view
    }

    private fun menuJeansFunction(view : View) {
        // 1. RecyclerView
        val rvAdapter = MenuFragRvAdapter(requireContext(), arguments?.getString("KEY")!!)
        view.lvMenuJeansFrag.adapter = rvAdapter
        view.lvMenuJeansFrag.layoutManager = GridLayoutManager(requireContext(), 2)
        rvAdapter.notifyDataSetChanged()

        // add spaces
        val spaceDecoration = VerticalSpaceItemDecoration(4, 4, 4, 4)
        view.lvMenuJeansFrag.addItemDecoration(spaceDecoration)
    }

    companion object {
        private const val TAG = "MenuJeansFragment"
    }
}