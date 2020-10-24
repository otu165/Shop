package com.example.shopping.feature.menu.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopping.R
import kotlinx.android.synthetic.main.fragment_menu_jeans.*
import kotlinx.android.synthetic.main.fragment_menu_shose.*
import kotlinx.android.synthetic.main.fragment_menu_shose.view.*

class MenuShoesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_menu_shose, container, false)

        menuShoesFunction(view)

        Log.d(TAG, "${TAG} created")
        return view
    }

    private fun menuShoesFunction(view : View) {
        // 1. ListView
        val listAdapter = MenuFragListViewAdapter(requireContext(), arguments?.getString("KEY")!!)
        view.lvMenuShoesFrag.adapter = listAdapter
    }

    companion object {
        private const val TAG = "MenuShoesFragment"
    }
}