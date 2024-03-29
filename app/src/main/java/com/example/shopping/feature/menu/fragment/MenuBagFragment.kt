package com.example.shopping.feature.menu.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.R
import kotlinx.android.synthetic.main.fragment_menu_bag.*
import kotlinx.android.synthetic.main.fragment_menu_bag.view.*
import kotlinx.android.synthetic.main.fragment_menu_dress.*
import kotlinx.android.synthetic.main.fragment_menu_outer.view.*

class MenuBagFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_menu_bag, container, false)

        menuBagFunction(view)

        Log.d(TAG, "${TAG} created")
        return view;
    }

    private fun menuBagFunction(view: View) {
        // 1. RecyclerView
        Log.d(TAG, "key : ${arguments?.getString("KEY")!!}")
        val rvAdapter = MenuFragRvAdapter(requireContext(), arguments?.getString("KEY")!!)
        view.lvMenuBagFrag.adapter = rvAdapter
        view.lvMenuBagFrag.layoutManager = GridLayoutManager(requireContext(), 2)
        rvAdapter.notifyDataSetChanged()

        // add spaces
        val spaceDecoration = VerticalSpaceItemDecoration(4, 4, 4, 4)
        view.lvMenuBagFrag.addItemDecoration(spaceDecoration)

        view.imgFragBagUp.setOnClickListener {
            view.lvMenuBagFrag.smoothScrollToPosition(0)
        }

        view.lvMenuBagFrag.addOnScrollListener(
                object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        if(dy > 0) {
                            if(!view.imgFragBagUp.isVisible)
                                view.imgFragBagUp.visibility = View.VISIBLE
                        }
                        else {
                            if(view.imgFragBagUp.isVisible)
                                view.imgFragBagUp.visibility = View.INVISIBLE
                        }

                        super.onScrolled(recyclerView, dx, dy)
                    }
                }
        )
    }

    companion object {
        private const val TAG = "MenuBagFragment"
    }
}