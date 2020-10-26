package com.example.shopping.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.data.main.MainGridViewData
import com.example.shopping.feature.bookmark.BookmarkFragment
import com.example.shopping.feature.login.SignInFragment
import com.example.shopping.feature.main.fragment.MainFragment
import com.example.shopping.feature.menu.MenuActivity
import com.example.shopping.feature.recommend.RecommendFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_navigation_bar_main.*

class MainActivity : AppCompatActivity() {
    private var backKeyPressed : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "${TAG} created")
        mainFunction()
    }

    private fun mainFunction() {
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
                            transaction.replace(R.id.frameMain, MainFragment())
                        }
                        R.id.recommend -> {
                            transaction.replace(R.id.frameMain, RecommendFragment())
                        }
                        R.id.bookmark -> {
                            transaction.replace(R.id.frameMain, BookmarkFragment())
                        }
                        else -> {
                            transaction.replace(R.id.frameMain, SignInFragment())
                        }
                    }
                    transaction.commit()

                    return item.isChecked
                }

            }
        )
    }

    override fun onBackPressed() {
        val toast : Toast = Toast.makeText(this, "\'뒤로\'버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)

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