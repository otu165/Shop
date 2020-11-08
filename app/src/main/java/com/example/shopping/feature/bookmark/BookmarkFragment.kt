package com.example.shopping.feature.bookmark

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.data.menu.MenuFragListViewData
import com.example.shopping.feature.menu.fragment.VerticalSpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_bookmark.view.*

class BookmarkFragment : Fragment() {
    var size : Int = 0
    var data = mutableListOf<MenuFragListViewData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bookmark, container, false)

        bookmarkFragFunction(view)
        return view
    }

    private fun bookmarkFragFunction(view: View) {
        // depending on user's bookmark, decide to show or hide description

        // 북마크한 아이템의 개수 확인

        FirebaseService.db.collection("bookmark").document(FirebaseService.auth.currentUser?.uid.toString()).get()
            .addOnSuccessListener {
                if(it.data == null) { // bookmark 아이템 없음
                    return@addOnSuccessListener
                }

                // bookmark 아이템 존재
                size = if (it.data?.size == 0) 0 else it.data?.size!!

                if (size > 0)
                    view.txtFragBookmarkDescription.text = ""

                // recycler view 초기화
                data.clear()

                for (key in it.data?.keys!!) {
                    val hash = it.get(key) as HashMap<String, String>
                    data.add(MenuFragListViewData(hash["image"]?.toInt()!!, hash["title"]!!, hash["description"]!!, hash["cost"]!! ))
                }

                val rvAdapter = BookmarkRvAdapter(requireContext(), data)
                view.rvFragBookmark.adapter = rvAdapter
                view.rvFragBookmark.layoutManager = GridLayoutManager(requireContext(), 2)

                val decoration = VerticalSpaceItemDecoration(4, 4, 4, 4)
                view.rvFragBookmark.addItemDecoration(decoration)

                rvAdapter.notifyDataSetChanged()
            }
    }
}