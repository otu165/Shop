package com.example.shopping.feature.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping.R
import com.example.shopping.api.Service
import com.example.shopping.feature.main.MainActivity
import com.example.shopping.feature.main.MainFragment
import kotlinx.android.synthetic.main.fragment_search.view.*

class SearchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        searchFunction(view)
        return view
    }

    private fun searchFunction(view : View) {
        // TODO Firebase 에서 넘겨주는 데이터로 교체
        val rvAdapter = SearchLvAdapter(requireContext(), Service.getSearchData())
        view.rvFragSearch.adapter = rvAdapter

        // TODO actionbar home 기능 replaceFragment 로 수정

        // close action
        view.txtFragSearchClose.setOnClickListener {
            // TODO 키보드 닫기 (signup activity 수정할 때 같이 수정)
            // TODO searchView 닫기
            (activity as MainActivity).replaceFragment(MainFragment())
        }

    }
}