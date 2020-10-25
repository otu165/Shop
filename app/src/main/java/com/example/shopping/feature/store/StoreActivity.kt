package com.example.shopping.feature.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.shopping.R
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

    }

    companion object {
        private const val TAG = "StoreActivity"
    }
}