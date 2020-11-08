package com.example.shopping.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.feature.bookmark.BookmarkFragment
import com.example.shopping.feature.login.MyPageFragment
import com.example.shopping.feature.login.SignInFragment
import com.example.shopping.feature.main.search.SearchFragment
import com.example.shopping.feature.menu.MenuActivity
import com.example.shopping.feature.recommend.RecommendFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var backKeyPressed : Long = 0
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "${TAG} created")
        mainFunction()
    }

    private fun mainFunction() {
        // initiate Firebase
        FirebaseService.auth = Firebase.auth
        FirebaseService.db = FirebaseFirestore.getInstance()
        FirebaseService.storage = FirebaseStorage.getInstance()

        // setting toolbar
        setSupportActionBar(tbMain) // 툴바를 액티비티의 actionbar 로 지정
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // drawer 꺼낼 홈 버튼 활성화

        // navigation view listener 지정
        nvMain.setNavigationItemSelectedListener(this)

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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.coat -> {
                startMenuActivity(0)
            }
            R.id.top -> {
                startMenuActivity(1)
            }
            R.id.dress -> {
                startMenuActivity(2)
            }
            R.id.pants -> {
                startMenuActivity(3)
            }
            R.id.skirt -> {
                startMenuActivity(4)
            }
            R.id.shoes -> {
                startMenuActivity(5)
            }
            R.id.bag -> {
                startMenuActivity(6)
            }
        }

        drawerLayout.closeDrawers()
        return false
    }

    fun startMenuActivity(sort : Int) {
        startActivity(Intent(this, MenuActivity::class.java).putExtra("sort", sort))
    }

    // action bar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_icon, menu)

        val search = menu?.findItem(R.id.search)
        searchView = search?.actionView as SearchView
        searchView.maxWidth = Integer.MAX_VALUE // 검색창 길이 커스텀, title 안보이게 됨

        searchView.queryHint = "Search here .."
        searchView.setOnSearchClickListener(
                object : View.OnClickListener {
                    override fun onClick(p0: View?) {
                        // fragment 교체하기
                        supportFragmentManager.beginTransaction().replace(R.id.frameMain, SearchFragment()).addToBackStack("search").commit()
                    }

                }
        )

        searchView.setOnQueryTextListener(
                object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(p0: String?): Boolean {
                        Log.d(TAG, "user input : $p0")
                        return false
                    }

                    override fun onQueryTextChange(p0: String?): Boolean {
                        return true
                    }
                }
        )

        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        // drawer 열린 상태에서의 backPressed 처리
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers()
            return
        }

        // searchView 열린 상태에서의 backPressed 처리
        if(!searchView.isIconified) {
            searchView.onActionViewCollapsed()
            return
        }

        val toast : Toast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT)

        if(System.currentTimeMillis() > backKeyPressed + 2000) {
            backKeyPressed = System.currentTimeMillis()
            toast.show()
        } else if (System.currentTimeMillis() <= backKeyPressed + 2000) {
            this.finish()
            toast.cancel()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> { // 메뉴 버튼
                drawerLayout.openDrawer(GravityCompat.START) // drawer 열기
            }
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}