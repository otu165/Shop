package com.example.shopping.feature.recommend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.shopping.R
import kotlinx.android.synthetic.main.fragment_recommend.*

class RecommendFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_recommend, container, false)

        recommendFunction(view)
        return view
    }

    private fun recommendFunction(view : View) {
        // 1. RecyclerView
        val rv = view.findViewById<RecyclerView>(R.id.rvRecFrag)
        val rvAdapter = RecRvAdapter(requireContext())

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        rvAdapter.notifyDataSetChanged()
    }
}