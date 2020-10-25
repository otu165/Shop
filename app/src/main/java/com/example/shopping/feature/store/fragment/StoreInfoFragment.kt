package com.example.shopping.feature.store.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopping.R

class StoreInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_store_info, container, false)

        infoFunction()

        Log.d(TAG, "$TAG created")
        return view
    }

    private fun infoFunction() {

    }

    companion object {
        private const val TAG = "StoreInfoFragment"
    }
}