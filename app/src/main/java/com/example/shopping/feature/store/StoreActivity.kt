package com.example.shopping.feature.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.shopping.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_store.*

class StoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        Log.d(TAG, "${TAG} created")
        storeFunction()
    }

    private fun storeFunction() {
        // 1. ViewPager
        val vpAdapter = StoreVpAdapter(this)
        vpStore.adapter = vpAdapter

        // 2. title & description update

        // 3. Fragment + ViewPager
        val fragmentPagerAdapter = StoreFragmentPagerAdapter(supportFragmentManager)
        vpStoreBelow.adapter = fragmentPagerAdapter

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

        vpStoreBelow.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabStore))
    }

    companion object {
        private const val TAG = "StoreActivity"
    }
}