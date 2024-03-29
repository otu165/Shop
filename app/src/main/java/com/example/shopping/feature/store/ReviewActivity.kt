package com.example.shopping.feature.store

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.shopping.R
import com.example.shopping.api.FirebaseService
import com.example.shopping.data.ReviewData
import com.google.firebase.firestore.SetOptions
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity() {
    lateinit var name : String // 아이템 이름
    var img : Int? = null // 아이템 리소스

    var rating : String = "0" // TODO 별점 최저 0.5점으로 설정
    var nickname : String = ""
    var dataSize : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        reviewFunction()
    }

    private fun reviewFunction() {
        if(intent.hasExtra("name"))
            name = intent.getStringExtra("name")

        if(intent.hasExtra("image"))
            img = intent.getIntExtra("image", 0)

        txtReview.text = name
        imgReview.setImageResource(img!!)

        Log.d("TAG", "name : $name")

        getReviewListSize()

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

    private fun getReviewListSize() {
        FirebaseService.db.collection("review")
            .document(name)
            .get()
            .addOnSuccessListener { it->
                if(it.data == null)
                    dataSize = 0
                else
                    dataSize = it.data?.size !!
            }
    }

    private fun writeReview() {

        val data = hashMapOf(dataSize.toString() to ReviewData(nickname, rating, edtReview.text.toString()))

        FirebaseService.db.collection("review")
            .document(name)
            .set(data, SetOptions.merge())
            .addOnSuccessListener {
                setResult(Activity.RESULT_OK)
                this.finish()
            }
    }
}