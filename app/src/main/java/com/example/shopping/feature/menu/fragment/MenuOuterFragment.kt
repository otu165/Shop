package com.example.shopping.feature.menu.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopping.R
import com.example.shopping.feature.store.StoreActivity
import kotlinx.android.synthetic.main.fragment_menu_outer.*
import kotlinx.android.synthetic.main.fragment_menu_outer.view.*

class MenuOuterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view : View =  inflater.inflate(R.layout.fragment_menu_outer, container, false)
        menuOuterFunction(view)

        Log.d(TAG, "${TAG} created")
        return view
    }

    private fun menuOuterFunction(view : View) {

        // 1. ListView
        val listViewAdapter = MenuFragListViewAdapter(requireContext(), arguments?.getString("KEY")!!)
        view.lvMenuOuterFrag.adapter = listViewAdapter

        view.lvMenuOuterFrag.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(requireContext(), StoreActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val TAG = "MenuOuterFragment"
    }
}