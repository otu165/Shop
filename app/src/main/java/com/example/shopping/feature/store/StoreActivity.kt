package com.example.shopping.feature.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.feature.menu.fragment.outer.SelectedMenu
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.SetOptions
import kotlinx.android.synthetic.main.activity_store.*

class StoreActivity : AppCompatActivity() {
    lateinit var item : SelectedMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        Log.d(TAG, "${TAG} created")
        storeFunction()
    }

    private fun storeFunction() {

        // 1. img $ title & description & cost update
        if(intent.hasExtra("item"))
            item = intent.getParcelableExtra("item")

        txtStoreName.text = item.title
        txtStoreDescription.text = item.description
        txtStoreCost.text = item.cost
        imgStore.setImageResource(item.image.toInt())

        // 2. Fragment + ViewPager
        val fragmentPagerAdapter = StoreFragmentPagerAdapter(supportFragmentManager, item.title, item.image.toInt())
        vpStoreBelow.adapter = fragmentPagerAdapter
        vpStoreBelow.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabStore))

        tabStore.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if(tab != null) {
                        vpStoreBelow.currentItem = tab.position
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            }
        )

        // 3. bookmark
        ctvStoreBookmark.setOnClickListener {
            if(FirebaseService.auth.currentUser == null) {
                Toast.makeText(this, "please sign in first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(ctvStoreBookmark.isChecked) { // DB 에서 제거
                ctvStoreBookmark.toggle()
                removeItemFromBookmark()
            }
            else {
                ctvStoreBookmark.toggle()
                addItemToBookmark()
            }
        }

        // 4. initialize bookmark
        if(FirebaseService.auth.currentUser != null) {
            FirebaseService.db.collection("bookmark").document(FirebaseService.auth.currentUser?.uid.toString()).get()
                .addOnSuccessListener {
                    if(it.data == null) {
                        return@addOnSuccessListener
                    }

                    // 북마크 되어있나 확인
                    for(name in it.data?.keys!!) {
                        if(name == item.title) {
                            ctvStoreBookmark.isChecked = true
                            break
                        }
                    }
                }
        }

        // 5. purchase
        btnStoreBuy.setOnClickListener {
            Toast.makeText(this, "Sorry, not available now", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addItemToBookmark() {
        val data = hashMapOf(item.title to item)

        FirebaseService.db.collection("bookmark").document(FirebaseService.auth.currentUser?.uid!!)
            .set(data, SetOptions.merge())
    }

    private fun removeItemFromBookmark() {
        val updates = hashMapOf<String, Any>(item.title to FieldValue.delete())

        FirebaseService.db.collection("bookmark").document(FirebaseService.auth.currentUser?.uid!!)
            .update(updates)
    }

    companion object {
        private const val TAG = "StoreActivity"
    }
}