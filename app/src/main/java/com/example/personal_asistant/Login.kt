package com.example.personal_asistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onSignUpClick(view: View) {
        startActivity(Intent(this, Signup::class.java))
    }

    fun loginAction(view: View) {
        val mailText: String = findViewById<EditText>(R.id.mail_login_input).text.toString()
        val passwordText: String = findViewById<EditText>(R.id.password_login_input).text.toString()
        if (mailText.isNotEmpty() && passwordText.isNotEmpty()) {
            val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signInWithEmailAndPassword(mailText, passwordText).addOnCompleteListener {
                if (it.isSuccessful) {
                    val goals: Intent = Intent(this, Goals::class.java)
                    goals.putExtra("email", mailText)
                    goals.putExtra("password", passwordText)
                    startActivity(goals)
                } else {
                    Toast.makeText(this, "Error try again!", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this, "Please fill all areas!!", Toast.LENGTH_LONG).show()
        }
    }
}