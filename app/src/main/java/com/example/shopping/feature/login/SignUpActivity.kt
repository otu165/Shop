package com.example.shopping.feature.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.api.FirebaseService.auth
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
                // Firebase 서버 요청
                FirebaseService.auth.createUserWithEmailAndPassword(edtSignUpId.text.toString(), edtSignUpPwd.text.toString())
                    .addOnCompleteListener(this) {task ->
                        if(task.isSuccessful) {
                            Toast.makeText(this, "sign up success", Toast.LENGTH_SHORT).show()
                            this.finish()
                        }
                        else {
                            val toast : Toast = Toast.makeText(this, "please input\nvalid e-mail and password", Toast.LENGTH_SHORT)
                            val layout : LinearLayout = toast.view as LinearLayout

                            if(layout.childCount > 0)
                                (layout.getChildAt(0) as TextView).gravity = Gravity.CENTER

                            toast.show()
                        }
                    }
            }
            else {
                Toast.makeText(this, "please fill all item", Toast.LENGTH_SHORT).show()
            }
        }

        // google sign up button click event
    }

    private fun isValid(id : String?, pwd : String?, nick : String?) : Boolean {
        return !id.isNullOrEmpty() && !pwd.isNullOrEmpty() && !nick.isNullOrEmpty()
    }
}