package com.example.shopping.api

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

object FirebaseService {
    lateinit var auth : FirebaseAuth
    lateinit var db : FirebaseFirestore
    lateinit var storage : FirebaseStorage
}