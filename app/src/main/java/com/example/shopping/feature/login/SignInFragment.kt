package com.example.shopping.feature.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shopping.R
import com.example.shopping.feature.main.MainActivity

class SignInFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_sign_in, container, false)

        signInFunction()

        Log.d(TAG, "$TAG created")
        return view
    }

    private fun signInFunction() {

    }

    companion object {
        private const val TAG = "SignInFragment"
    }
}