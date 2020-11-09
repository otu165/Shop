package com.example.shopping.feature.store.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.data.ReviewData
import com.example.shopping.feature.store.ReviewActivity
import kotlinx.android.synthetic.main.fragment_store_review.view.*

class StoreReviewFragment : Fragment() {
    lateinit var rvAdapter : StoreReviewRvAdapter
    lateinit var name : String // 옷 이름
    var img : Int? = null // 옷 리소스
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
        Log.d("TAG", "${arguments?.getString("name")!!}")
        name = arguments?.getString("name")!!
        img = arguments?.getInt("image")!!

        // 1. RecyclerView
        rvAdapter = StoreReviewRvAdapter(requireContext())
        val recyclerView = view.rvFragStoreReview
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getReviewData()

        // 2. button click event
        view.btnFragStore.setOnClickListener {
            FirebaseService.auth.currentUser?.let {
                val intent = Intent(requireContext(), ReviewActivity::class.java)
                    .putExtra("name", name)
                    .putExtra("image", img)

                startActivityForResult(intent, REQUEST_CODE)
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
        FirebaseService.db.collection("review").document(name).get()
            .addOnSuccessListener {
                list.clear()

                for(data in it.data?.keys!!) {
                    Log.d("TAG", "${it.get(data)}")

                    val hash = it.get(data) as HashMap<String, String>
                    list.add(ReviewData(hash["nickname"]!!, hash["rating"]!!, hash["review"]!!))
                }

                rvAdapter.data = list
                rvAdapter.notifyDataSetChanged()

                // set TextView Invisible
                if(list.size != 0)
                    view!!.txtFragStoreReview.visibility = View.GONE
            }
    }


    companion object {
        private const val REQUEST_CODE = 1000
        private const val TAG = "StoreReviewFragment"
    }
}