package com.example.shopping.feature.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
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

        // 1. title & description update

        // 2. Fragment + ViewPager
        val fragmentPagerAdapter = StoreFragmentPagerAdapter(supportFragmentManager)
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
    }

    fun replaceFragment(fragment : Fragment) {

    }

    companion object {
        private const val TAG = "StoreActivity"
    }
}