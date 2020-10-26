package com.example.shopping.feature.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shopping.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpFunction()
    }

    private fun signUpFunction() {
        // SignUp button click event
        btnSignUp.setOnClickListener {
            if(isValid(edtSignUpId.text.toString(), edtSignUpPwd.text.toString(), edtSignUpNickname.text.toString())) {
                Toast.makeText(this, "회원가입 요청 가능", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "모든 항목을 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValid(id : String?, pwd : String?, nick : String?) : Boolean {
        return !id.isNullOrEmpty() && !pwd.isNullOrEmpty() && !nick.isNullOrEmpty()
    }
}