package com.example.shopping.feature.main.search

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping.R
import com.example.shopping.api.Service
import com.example.shopping.feature.main.MainActivity
import com.example.shopping.feature.main.MainFragment
import kotlinx.android.synthetic.main.fragment_search.view.*

class SearchFragment : Fragment() {
    lateinit var imm : InputMethodManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        searchFunction(view)
        return view
    }

    private fun searchFunction(view : View) {
        imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // TODO Firebase 에서 넘겨주는 데이터로 교체
        val rvAdapter = SearchLvAdapter(requireContext(), Service.getSearchData())
        view.rvFragSearch.adapter = rvAdapter

        // TODO actionbar home 기능 replaceFragment 로 수정

        // close action
        view.txtFragSearchClose.setOnClickListener {
            (activity as MainActivity).finishSearchView()
            (activity as MainActivity).replaceFragment(MainFragment())
        }

    }
}