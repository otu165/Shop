package com.example.shopping.api

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseService {
    lateinit var auth : FirebaseAuth
    lateinit var db : FirebaseFirestore
}