package com.example.shopping.feature.store

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity() {
    var rating : String = "0" // TODO 별점 최저 0.5점으로 설정
    var nickname : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        reviewFunction()
    }

    private fun reviewFunction() {
        // setRate
        rbReview.setOnRatingBarChangeListener { ratingBar, fl, b ->
            rating = fl.toString()
        }

        // get nickname
        FirebaseService.db.collection("user")
            .document(FirebaseService.auth.currentUser?.uid.toString())
            .get()
            .addOnSuccessListener {it ->
                nickname = it.get("nickname").toString()
            }

        // button click event
        btnReview.setOnClickListener {
            if(edtReview.text.isNullOrEmpty()) {
                Toast.makeText(this, "please write down the comment", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            writeReview()

            Toast.makeText(this, "thank you for comment!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun writeReview() {

        val data = hashMapOf(
            "nickname" to nickname,
            "rating" to rating,
            "review" to edtReview.text.toString()
        )

        FirebaseService.db.collection("review")
            .add(data)
            .addOnSuccessListener {
                setResult(Activity.RESULT_OK)
                this.finish()
            }
    }
}