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
import kotlinx.android.synthetic.main.fragment_menu_dress.*
import kotlinx.android.synthetic.main.fragment_menu_dress.view.*

class MenuDressFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_menu_dress, container, false)

        menuDressFunction(view)

        Log.d(TAG, "${TAG} created")
        return view;
    }

    private fun menuDressFunction(view : View) {
        // 1. RecyclerView
        val rvAdapter = MenuFragRvAdapter(requireContext(), arguments?.getString("KEY")!!)
        view.lvMenuDressFrag.adapter = rvAdapter
        view.lvMenuDressFrag.layoutManager = GridLayoutManager(requireContext(), 2)
        rvAdapter.notifyDataSetChanged()

        // add spaces
        val spaceDecoration = VerticalSpaceItemDecoration(4, 4, 4, 4)
        view.lvMenuDressFrag.addItemDecoration(spaceDecoration)

        view.imgFragDressUp.setOnClickListener {
            view.lvMenuDressFrag.smoothScrollToPosition(0)
        }

        view.lvMenuDressFrag.addOnScrollListener(
                object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        if(dy > 0) {
                            if(!view.imgFragDressUp.isVisible)
                                view.imgFragDressUp.visibility = View.VISIBLE
                        }
                        else {
                            if(view.imgFragDressUp.isVisible)
                                view.imgFragDressUp.visibility = View.INVISIBLE
                        }

                        super.onScrolled(recyclerView, dx, dy)
                    }
                }
        )
    }

    companion object {
        private const val TAG = "MenuDressFragment"
    }
}