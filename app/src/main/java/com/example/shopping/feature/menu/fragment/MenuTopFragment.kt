package com.example.shopping.feature.menu.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import kotlinx.android.synthetic.main.fragment_menu_bag.view.*
import kotlinx.android.synthetic.main.fragment_menu_skirt.*
import kotlinx.android.synthetic.main.fragment_menu_skirt.lvMenuSkirtFrag
import kotlinx.android.synthetic.main.fragment_menu_skirt.view.*
import kotlinx.android.synthetic.main.fragment_menu_top.*
import kotlinx.android.synthetic.main.fragment_menu_top.view.*

class MenuTopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_menu_top, container, false)

        menuTopFunction(view)

        Log.d(TAG, "${TAG} created")
        return view
    }

    private fun menuTopFunction(view : View) {
        // 1. RecyclerView
        val rvAdapter = MenuFragRvAdapter(requireContext(), arguments?.getString("KEY")!!)
        view.lvMenuTopFrag.adapter = rvAdapter
        view.lvMenuTopFrag.layoutManager = GridLayoutManager(requireContext(), 2)
        rvAdapter.notifyDataSetChanged()

        // add spaces
        val spaceDecoration = VerticalSpaceItemDecoration(4, 4, 4, 4)
        view.lvMenuTopFrag.addItemDecoration(spaceDecoration)

        view.imgFragTopUp.setOnClickListener {
            view.lvMenuTopFrag.smoothScrollToPosition(0)
        }

        view.lvMenuTopFrag.addOnScrollListener(
                object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        if(dy > 0) {
                            if(!view.imgFragTopUp.isVisible)
                                view.imgFragTopUp.visibility = View.VISIBLE
                        }
                        else {
                            if(view.imgFragTopUp.isVisible)
                                view.imgFragTopUp.visibility = View.INVISIBLE
                        }

                        super.onScrolled(recyclerView, dx, dy)
                    }
                }
        )
    }

    companion object {
        private const val TAG = "MenuTopFragment"
    }
}