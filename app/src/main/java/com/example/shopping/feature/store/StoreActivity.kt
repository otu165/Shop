package com.example.shopping.feature.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.shopping.R

class StoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        Log.d(TAG, "${TAG} created")
        storeFunction()
    }

    private fun storeFunction() {

    }

    companion object {
        private const val TAG = "StoreActivity"
    }
}