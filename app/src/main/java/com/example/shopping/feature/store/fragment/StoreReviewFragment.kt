package com.example.shopping.feature.store.fragment

import android.app.Activity
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.data.ReviewData
import com.example.shopping.feature.store.ReviewActivity
import kotlinx.android.synthetic.main.fragment_store_review.view.*

class StoreReviewFragment : Fragment() {
    lateinit var rvAdapter : StoreReviewRvAdapter
    var list = mutableListOf<ReviewData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_store_review, container, false)

        reviewFunction(view)
        return view
    }

    private fun reviewFunction(view : View) {
        // 1. RecyclerView
        rvAdapter = StoreReviewRvAdapter(requireContext())
        val recyclerView = view.rvFragStoreReview
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getReviewData()

        // 2. button click event
        view.btnFragStore.setOnClickListener {
            FirebaseService.auth.currentUser?.let {
                startActivityForResult(Intent(requireContext(), ReviewActivity::class.java), REQUEST_CODE)
                return@setOnClickListener
            }

            Toast.makeText(requireContext(), "please sign in first", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            REQUEST_CODE -> {
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        if(rvAdapter.itemCount == 0) { // textView 없애기
                            view?.txtFragStoreReview?.visibility = View.GONE
                        }

                        getReviewData()
                    }
                }
            }
        }
    }

    private fun getReviewData() {
        FirebaseService.db.collection("review").get()
            .addOnSuccessListener { it ->
                list.clear()

                for (data in it) {
                    list.add(ReviewData(data.get("nickname").toString(), data.get("rating").toString(), data.get("review").toString()))
                }
                rvAdapter.data = list
                rvAdapter.notifyDataSetChanged()

                // set TextView Visible or Invisible
                if(list.size != 0) view!!.txtFragStoreReview.visibility = View.GONE

                Log.d("TAG", "review updated")
            }
    }


    companion object {
        private const val REQUEST_CODE = 1000
        private const val TAG = "StoreReviewFragment"
    }
}