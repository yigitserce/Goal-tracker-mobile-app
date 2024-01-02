package com.example.personal_asistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class Goals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals)

        val email: String = intent.getStringExtra("email").toString()
        val password: String = intent.getStringExtra("password").toString()
        val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val firebaseDatabase = Firebase.firestore
//                firebaseDatabase.collection("goals")
            }
        }
    }

    fun onLogOutClick(view: View) {
        startActivity(Intent(this, Login::class.java))
    }
}