package com.example.shopping.feature.menu.fragment

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SnapHelper
import com.example.shopping.R
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import kotlinx.android.synthetic.main.fragment_menu_outer.view.*


class MenuOuterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View =  inflater.inflate(R.layout.fragment_menu_outer, container, false)
        menuOuterFunction(view)

        Log.d(TAG, "${TAG} created")
        return view
    }

    private fun menuOuterFunction(view: View) {
        // 1. RecyclerView (best seller)
        val adapter = MenuFragBestRvAdapter(requireContext(), arguments?.getString("KEY")!!)
        view.rvFragOuter.adapter = adapter
        view.rvFragOuter.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // add spaces
        val decoration = VerticalSpaceItemDecoration(6, 4, 4, 6)
        view.rvFragOuter.addItemDecoration(decoration)

        // add snapHelper
        val snapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(view.rvFragOuter)

        adapter.notifyDataSetChanged()

        // 2. RecyclerView (all item)

        val rvAdapter = MenuFragRvAdapter(requireContext(), arguments?.getString("KEY")!!)
        view.lvMenuOuterFrag.adapter = rvAdapter
        view.lvMenuOuterFrag.layoutManager = GridLayoutManager(requireContext(), 2)

        // add spaces
        val spaceDecoration = VerticalSpaceItemDecoration(4, 4, 4, 4)
        view.lvMenuOuterFrag.addItemDecoration(spaceDecoration)

        rvAdapter.notifyDataSetChanged()
    }

    companion object {
        private const val TAG = "MenuOuterFragment"
    }
}