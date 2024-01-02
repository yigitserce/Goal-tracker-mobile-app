package com.example.personal_asistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    fun onLogInClick(view: View) {
        startActivity(Intent(this, Login::class.java))
    }

    fun signUpAction(view: View) {
        val mailText: String = findViewById<EditText>(R.id.mail_signup_input).text.toString()
        val mailAgainText: String = findViewById<EditText>(R.id.mail_again_signup_input).text.toString()
        val passwordText: String = findViewById<EditText>(R.id.password_signup_input).text.toString()
        if (mailText.isNotEmpty() && passwordText.isNotEmpty()) {
            if (mailText == mailAgainText) {
                val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
                firebaseAuth.createUserWithEmailAndPassword(mailText, passwordText).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val goals: Intent = Intent(this, Goals::class.java)
                        goals.putExtra("email", mailText)
                        goals.putExtra("password", passwordText)
                        startActivity(goals)
                    } else {
                        Toast.makeText(this, "Error try again!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } else {
            Toast.makeText(this, "Please fill all areas!!", Toast.LENGTH_LONG).show()
        }
    }
}