package com.example.shopping.feature.login

import android.annotation.SuppressLint
import android.app.Activity
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
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment() {
    private lateinit var edtEmail : TextInputEditText
    private lateinit var edtPwd : TextInputEditText
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

    @SuppressLint("ResourceAsColor")
    private fun signInFunction(view : View) {
        // 1. 뷰 초기화
        initiateView(view)

        // 2. SignUp request click event
        txtSignUp.setOnClickListener {
            val intent = Intent(requireContext(), SignUpActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
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
                            Toast.makeText(requireContext(), "Welcome", Toast.LENGTH_SHORT).show()
                            (activity as MainActivity).replaceFragment(MyPageFragment())

                        }
                        else {
                            // 로그인 실패
                            Toast.makeText(requireContext(), "wrong e-mail or password", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else {
                Toast.makeText(requireContext(), "please fill all item", Toast.LENGTH_SHORT).show()
            }
        }

        btnSignIn.setBackgroundColor(R.color.black)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            REQUEST_CODE -> {
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        (activity as MainActivity).replaceFragment(MyPageFragment())
                    }
                }
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
        private const val REQUEST_CODE = 1000
        private const val TAG = "SignInFragment"
    }
}