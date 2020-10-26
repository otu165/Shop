package com.example.shopping.feature.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopping.R

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_sign_up, container, false)

        signUpFunction()

        Log.d(TAG, "$TAG created")
        return view
    }

    private fun signUpFunction() {

    }

    companion object {
        private const val TAG = "SignUpFragment"
    }
}