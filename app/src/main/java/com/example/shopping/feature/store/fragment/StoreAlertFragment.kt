package com.example.shopping.feature.store.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopping.R

class StoreAlertFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_store_alert, container, false)

        alertFunction()

        Log.d(TAG, "$TAG created")
        return view
    }

    private fun alertFunction() {

    }

    companion object {
        private const val TAG = "StoreAlertFragment"
    }
}