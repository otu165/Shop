package com.example.shopping.feature.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.viewpager.widget.ViewPager
import com.example.shopping.R
import com.example.shopping.feature.menu.MenuActivity

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_main, container, false)

        mainFunction(view)

        Log.d(TAG, "$TAG created")
        return view
    }

    private fun mainFunction(view : View) {
        // 1. ViewPager
        val vpAdapter = MainViewPagerAdapter(requireContext())
        view.findViewById<ViewPager>(R.id.viewPagerMain).adapter = vpAdapter

        // 2. GridView
        // ERROR 충분한 높이를 지정해주지 않으면 전체가 출력되지 않는 문제
        val gridView = view.findViewById<GridView>(R.id.gridViewMain)
        val gvAdapter = MainGridViewAdapter(requireContext())
        gridView.adapter = gvAdapter

        gridView.setOnItemClickListener { adapterView, view, i, l ->
            // TODO 선택된 아이템 name 정보 넘기기
            val intent = Intent(requireContext(), MenuActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val TAG = "MainFragment"
    }
}