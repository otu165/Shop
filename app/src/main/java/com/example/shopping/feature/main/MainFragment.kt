package com.example.shopping.feature.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.shopping.R
import com.example.shopping.feature.menu.MenuActivity
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_main, container, false)

        mainFunction(view)

        Log.d(TAG, "$TAG created")
        return view
    }

    private fun mainFunction(view : View) {
        // 1. ViewPager
        val vpAdapter = MainViewPagerAdapter(requireContext())
        view.findViewById<ViewPager>(R.id.viewPagerMain).adapter = vpAdapter

        // 2. RecyclerView
        val rvAdapter = MainRvAdapter(requireContext())
        view.rvMain.adapter = rvAdapter
        view.rvMain.layoutManager = GridLayoutManager(requireContext(), 2)
        rvAdapter.notifyDataSetChanged()
    }

    companion object {
        private const val TAG = "MainFragment"
    }
}