package com.example.shopping.feature.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.feature.main.MainActivity
import com.google.firebase.ktx.Firebase

class MyPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_my_page, container, false)

        myPageFunction(view)
        return view
    }

    private fun myPageFunction(view : View) {
        // 1. 사용자의 Firebase 데이터 가져오기
        
        val btnSignOut : TextView = view.findViewById(R.id.txtFragMyPageSignOut)

        btnSignOut.setOnClickListener {
            FirebaseService.auth.signOut()
            Toast.makeText(requireContext(), "success sign out", Toast.LENGTH_SHORT).show()
            (activity as MainActivity).replaceFragment(SignInFragment())
        }
    }
}