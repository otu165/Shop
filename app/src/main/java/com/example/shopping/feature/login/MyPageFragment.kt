package com.example.shopping.feature.login

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.feature.main.MainActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_my_page.view.*

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

        val docRef = FirebaseService.db.collection("user")
            .document(FirebaseService.auth.currentUser?.uid.toString())

        docRef.get()
            .addOnSuccessListener { it ->
                view.txtMyPageNick.text = it.get("nickname").toString()
            }
        

        view.txtFragMyPageSignOut.setOnClickListener {
            FirebaseService.auth?.signOut()
            Toast.makeText(requireContext(), "success sign out", Toast.LENGTH_SHORT).show()
            (activity as MainActivity).replaceFragment(SignInFragment())
        }

        // 2. 이미지 변경

        // 3. 배송
        view.cvFragMyPageDelivery.setOnClickListener {
            Toast.makeText(view.context, "Sorry, not available now", Toast.LENGTH_SHORT).show()
        }

        // 4. 회원탈퇴
        view.cvFragMyPageRemove.setOnClickListener {
            MaterialAlertDialogBuilder(view.context)
                    .setTitle("Remove Account")
                    .setMessage("do you really want to remove your account?\nyou can't restore it")
                    .setNegativeButton("CANCEL") { dialogInterface: DialogInterface, i: Int -> // CANCEL

                    }
                    .setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int -> // OK

                        FirebaseService.auth.currentUser!!.delete().addOnSuccessListener {

                            // 로그아웃 처리
                            FirebaseService.auth.signOut()

                            // fragment 교체
                            (activity as MainActivity).replaceFragment(SignInFragment())
                        }
                        Toast.makeText(view.context, "completely remove account", Toast.LENGTH_SHORT).show()
                    }
                    .show()


        }

        // 이미지 다운로드 방법
        view.imgMyPageUser.setOnClickListener {
            val ref = FirebaseService.storage.getReference("images/flower_1.png")

            ref.downloadUrl.addOnSuccessListener {
                Glide.with(requireContext()).load(it).into(view.imgMyPageUser)
            }
        }

    }
}