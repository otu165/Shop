package com.example.shopping.feature.menu.fragment.outer

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import com.example.shopping.feature.menu.fragment.MenuFragBestRvAdapter
import com.example.shopping.feature.menu.fragment.MenuFragRvAdapter
import com.example.shopping.feature.menu.fragment.VerticalSpaceItemDecoration
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import kotlinx.android.synthetic.main.fragment_menu_outer.*
import kotlinx.android.synthetic.main.fragment_menu_outer.view.*


class MenuOuterFragment : Fragment() {
    lateinit var recyclerView: RecyclerView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View =  inflater.inflate(R.layout.fragment_menu_outer, container, false)
        menuOuterFunction(view)

        Log.d(TAG, "$TAG created")

        recyclerView = view.lvMenuOuterFrag
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
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

        view.svFragOuter.setOnScrollChangeListener(
                object : NestedScrollView.OnScrollChangeListener {
                    override fun onScrollChange(v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
                        if(scrollY > 0) { // 스크롤
                            if(!view.imgFragOuterUp.isVisible)
                                view.imgFragOuterUp.visibility = View.VISIBLE
                        }
                        else { // 최상단
                            if(view.imgFragOuterUp.isVisible)
                                view.imgFragOuterUp.visibility = View.INVISIBLE
                        }
                    }

                }
        )

        view.imgFragOuterUp.setOnClickListener {
            view.svFragOuter.fullScroll(ScrollView.FOCUS_UP)
        }

//        view.lvMenuOuterFrag.addOnScrollListener(
//                object : RecyclerView.OnScrollListener() {
//                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                        if(dy > 0) { // 아래로 스크롤
//                            floatingActionButton.hide()
//                            Log.d("TAG", "야 이거 되냐? 왜안돼는데")
//                        }
//                        else {
//                            floatingActionButton.show()
//                            Log.d("TAG", "이건되냐?")
//                        }
//
//                        super.onScrolled(recyclerView, dx, dy)
//                    }
//                }
//        )
    }

    fun goUp() {
        recyclerView.smoothScrollToPosition(0)
    }

    companion object {
        private const val TAG = "MenuOuterFragment"
    }
}