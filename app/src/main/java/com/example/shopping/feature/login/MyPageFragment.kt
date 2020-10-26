package com.example.shopping.feature.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.feature.main.MainActivity
import com.google.firebase.ktx.Firebase

class MyPageFragment : Fragment() {
    // TODO: Rename and change types of parameters

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
        val btnSignOut : Button = view.findViewById(R.id.btnFragMyPageSignOut)

        btnSignOut.setOnClickListener {
            FirebaseService.auth.signOut()
            Toast.makeText(requireContext(), "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
            (activity as MainActivity).replaceFragment(SignInFragment())
        }
    }
}