package com.example.shopping.feature.login

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.Gravity
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.api.FirebaseService.auth
import com.example.shopping.feature.main.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    lateinit var imm : InputMethodManager
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpFunction()
    }

    @SuppressLint("ResourceAsColor")
    private fun signUpFunction() {
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        handleEnter()

        signUpActivity.setOnClickListener {
            hideKeyboard()
        }

        // SignUp button click event
        btnSignUp.setOnClickListener {
            if(isValid(edtSignUpId.text.toString(), edtSignUpPwd.text.toString(), edtSignUpNickname.text.toString())) {
                // Firebase 서버 요청
                FirebaseService.auth.createUserWithEmailAndPassword(edtSignUpId.text.toString(), edtSignUpPwd.text.toString())
                    .addOnCompleteListener(this) {task ->
                        if(task.isSuccessful) {

                            setUserData()

                            setResult(Activity.RESULT_OK)
                            Toast.makeText(this, "success sign up", Toast.LENGTH_SHORT).show()

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
                Toast.makeText(this, "please fill all items", Toast.LENGTH_SHORT).show()
            }
        }


        // google sign up button click event
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // ERROR 회원가입 성공인데, 왜 로그인은 안될까?
        btnSignUpGoogle.setOnClickListener {
            Toast.makeText(this, "Sorry, not available now", Toast.LENGTH_SHORT).show()
//            signIn()
        }
    }

    private fun handleEnter() {
        edtSignUpId.setOnKeyListener { view, i, keyEvent ->
            if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KEYCODE_ENTER) {
                edtSignUpPwd.requestFocus()
            }

            true
        }

        edtSignUpPwd.setOnKeyListener { view, i, keyEvent ->
            if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KEYCODE_ENTER) {
                edtSignUpNickname.requestFocus()
            }

            true
        }

        edtSignUpNickname.setOnKeyListener { view, i, keyEvent ->
            if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KEYCODE_ENTER) {
                edtSignUpAddress.requestFocus()
            }

            true
        }

        edtSignUpAddress.setOnKeyListener { view, i, keyEvent ->
            if(keyEvent.action == KeyEvent.ACTION_DOWN && i == KEYCODE_ENTER) {
                hideKeyboard()
            }

            true
        }
    }

    private fun setUserData() {
        // 사용자의 별명 및 주소 저장
        val data = hashMapOf(
            "nickname" to edtSignUpNickname.text.toString(),
            "address" to edtSignUpAddress.text.toString()
        )

        FirebaseService.db.collection("user")
            .document(FirebaseService.auth.currentUser?.uid.toString())
            .set(data)
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)

                Toast.makeText(this, "success sign up", Toast.LENGTH_SHORT).show()

                this.finish()

            } catch (e: ApiException) {
                e.printStackTrace()
            }
        }
    }

    // [START auth_with_google]
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Snackbar.make(signUpActivity, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
                }
            }
    }
    // [END auth_with_google]

    private fun isValid(id : String?, pwd : String?, nick : String?) : Boolean {
        return !id.isNullOrEmpty() && !pwd.isNullOrEmpty() && !nick.isNullOrEmpty()
    }

    private fun hideKeyboard() {
        imm.hideSoftInputFromWindow(edtSignUpId.windowToken, 0)
        imm.hideSoftInputFromWindow(edtSignUpPwd.windowToken, 0)
        imm.hideSoftInputFromWindow(edtSignUpNickname.windowToken, 0)
        imm.hideSoftInputFromWindow(edtSignUpAddress.windowToken, 0)
    }

    companion object {
        private const val RC_SIGN_IN = 9001
    }
}