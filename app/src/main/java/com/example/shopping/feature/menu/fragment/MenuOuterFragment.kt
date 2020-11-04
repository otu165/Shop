package com.example.shopping.feature.menu.fragment

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopping.R
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
        // 1. RecyclerView

        Log.d(TAG, "key : ${arguments?.getString("KEY")!!}")

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