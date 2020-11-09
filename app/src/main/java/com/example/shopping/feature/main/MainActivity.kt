package com.example.shopping.feature.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
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
    lateinit var imm : InputMethodManager

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
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

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
        supportFragmentManager.beginTransaction().replace(R.id.frameMain, fragment).addToBackStack(null).commit()
    }

    // drawer select listener
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
            R.id.center -> { // 전화
                var intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:1372"))

                if(intent.resolveActivity(packageManager) != null)
                    startActivity(intent)
            }
            R.id.error -> { // 메일(EXTRA_EMAIL : 받는이, EXTRA_SUBJECT : 제목, EXTRA_TEXT : 내용)
                var intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:${getString(R.string.email)}")
                intent.putExtra(Intent.EXTRA_SUBJECT, "Error reports on Application, Wanna Shop")

                if(intent.resolveActivity(packageManager) != null)
                    startActivityForResult(intent, EMAIL_REQUEST_CODE)
            }
        }

        drawerLayout.closeDrawers()
        return false
    }

    private fun startMenuActivity(sort : Int) {
        startActivity(Intent(this, MenuActivity::class.java).putExtra("sort", sort))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> { // 메뉴 버튼
                if(searchView.isIconified) // SearchView 미사용
                    drawerLayout.openDrawer(GravityCompat.START) // drawer 열기
                else { // SearchView 사용중
                    // ERROR 현재 사용중인 프래그먼트로 넘어가기
                    replaceFragment(MainFragment())
                    finishSearchView()
                }
            }
        }

        return super.onOptionsItemSelected(item)
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

    fun finishSearchView() {
        searchView.onActionViewCollapsed()
        imm.hideSoftInputFromWindow(searchView.windowToken, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            EMAIL_REQUEST_CODE -> {
                val toast = Toast.makeText(this@MainActivity, "Success Error Report", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                // ERROR 사용자가 메일을 보냈을 때만 토스트를 띄워야 함
//                toast.show()
            }
        }
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
            supportFragmentManager.beginTransaction().replace(R.id.frameMain, MainFragment()).commit()
            return
        }

        // BNV 에 부착된 fragment 가 아닌 경우엔 back stack 으로 이동

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
        private const val EMAIL_REQUEST_CODE = 1000
        private const val TAG = "MainActivity"
    }
}