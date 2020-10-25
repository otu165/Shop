package com.example.shopping.feature.store.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping.R
import kotlinx.android.synthetic.main.fragment_store_review.view.*

class StoreReviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_store_review, container, false)

        reviewFunction(view)

        Log.d(TAG, "$TAG created")
        return view
    }

    private fun reviewFunction(view : View) {
        // 1. RecyclerView
        val rvAdapter = StoreReviewRvAdapter(requireContext())
        val recyclerView = view.rvFragStoreReview
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        rvAdapter.notifyDataSetChanged()
    }

    companion object {
        private const val TAG = "StoreReviewFragment"
    }
}