package com.example.shopping.feature.menu.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopping.R

class MenuDressFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        menuDressFunction()

        // Inflate the layout for this fragment
        Log.d(TAG, "${TAG} created")
        return inflater.inflate(R.layout.fragment_menu_dress, container, false)
    }

    private fun menuDressFunction() {

    }

    companion object {
        private const val TAG = "MenuDressFragment"
    }
}