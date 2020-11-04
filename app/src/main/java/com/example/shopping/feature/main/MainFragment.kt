package com.example.shopping.feature.main

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping.R
import com.example.shopping.feature.main.catogory.MainRvAdapter
import com.example.shopping.feature.main.hot.MainHotRvAdapter
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import kotlinx.android.synthetic.main.fragment_main.view.*
import me.angeldevil.autoscrollviewpager.AutoScrollViewPager

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
        val viewPager = view.findViewById<AutoScrollViewPager>(R.id.viewPagerMain)
        viewPager.adapter = vpAdapter

        // 1-1. add auto scroll
        viewPager.setScrollFactor(3.0) // adjust scroll speed
        viewPager.startAutoScroll(4000)

        // 2. RecyclerView
        val rvAdapter = MainRvAdapter(requireContext())
        view.rvMain.adapter = rvAdapter
        view.rvMain.layoutManager = GridLayoutManager(requireContext(), 2)
        rvAdapter.notifyDataSetChanged()

        // 3. RecyclerView
        val hotRvAdapter = MainHotRvAdapter(requireContext())
        view.rvFragMain.adapter = hotRvAdapter
        view.rvFragMain.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        hotRvAdapter.notifyDataSetChanged()

        // 3-1. add SnapHelper
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(view.rvFragMain)
    }

    companion object {
        private const val TAG = "MainFragment"
    }
}