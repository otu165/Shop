package com.example.shopping.feature.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.api.FirebaseService.auth
import com.example.shopping.feature.main.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment() {
    private lateinit var edtEmail : EditText
    private lateinit var edtPwd : EditText
    private lateinit var txtSignUp : TextView
    private lateinit var btnSignIn : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_sign_in, container, false)

        signInFunction(view)

        Log.d(TAG, "$TAG created")
        return view
    }

    private fun signInFunction(view : View) {
        // 1. 뷰 초기화
        initiateView(view)

        // 2. SignUp request click event
        txtSignUp.setOnClickListener {
            val intent = Intent(requireContext(), SignUpActivity::class.java)
            startActivity(intent)
        }

        // 3. SignIn request click event
        btnSignIn.setOnClickListener {
            if(isValid(edtEmail.text.toString(), edtPwd.text.toString())) {
                // TODO 데이터베이스 연동
                auth.signInWithEmailAndPassword(edtEmail.text.toString(), edtPwd.text.toString())
                    .addOnCompleteListener(requireActivity()) { task ->
                        if(task.isSuccessful) {
                            // 로그인 성공
                            val user = auth.currentUser
                            Toast.makeText(requireContext(), "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                            (activity as MainActivity).replaceFragment(MyPageFragment())
                        }
                        else {
                            // 로그인 실패
                            Toast.makeText(requireContext(), "아이디 또는 비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else {
                Toast.makeText(requireContext(), "모든 항목을 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValid(id : String?, pwd : String?) : Boolean {
        return !id.isNullOrEmpty() && !pwd.isNullOrEmpty()
    }

    private fun initiateView(view : View) {
        edtEmail = view.findViewById(R.id.edtSignInFragId)
        edtPwd = view.findViewById(R.id.edtSignInPwd)
        txtSignUp = view.findViewById(R.id.txtSignInFragSignUp)
        btnSignIn = view.findViewById(R.id.btnSignInFrag)
    }

    fun getInstance() : SignInFragment {
        return SignInFragment()
    }

    companion object {
        private const val TAG = "SignInFragment"
    }
}