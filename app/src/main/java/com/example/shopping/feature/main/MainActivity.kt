package com.example.shopping.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.feature.bookmark.BookmarkFragment
import com.example.shopping.feature.login.MyPageFragment
import com.example.shopping.feature.login.SignInFragment
import com.example.shopping.feature.recommend.RecommendFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var backKeyPressed : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "${TAG} created")
        mainFunction()
    }

    private fun mainFunction() {
        // initiate Firebase
        FirebaseService.auth = Firebase.auth

        // add MainFragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameMain, MainFragment()).commit()

        //  BottomNavigationBar
        bottomNavi.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    val transaction = supportFragmentManager.beginTransaction()

                    when(item.itemId) {
                        R.id.main -> {
                            transaction.replace(R.id.frameMain, MainFragment()).commit()
                            return true
                        }
                        R.id.recommend -> {
                            transaction.replace(R.id.frameMain, RecommendFragment()).commit()
                            return true
                        }
                        R.id.bookmark -> {
                            transaction.replace(R.id.frameMain, BookmarkFragment()).commit()
                            return true
                        }
                        else -> { // MyPage
                            val currentUser = FirebaseService.auth.currentUser
                            currentUser?.let {
                                transaction.replace(R.id.frameMain, MyPageFragment()).commit()
                                return true
                            }

                            transaction.replace(R.id.frameMain, SignInFragment()).commit()
                            return true
                        }
                    }

                    return false
                }
            }
        )
    }

    fun replaceFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameMain, fragment).commit()
    }

    override fun onBackPressed() {
        val toast : Toast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT)

        if(System.currentTimeMillis() > backKeyPressed + 2000) {
            backKeyPressed = System.currentTimeMillis()
            toast.show()
        } else if (System.currentTimeMillis() <= backKeyPressed + 2000) {
            this.finish()
            toast.cancel()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}