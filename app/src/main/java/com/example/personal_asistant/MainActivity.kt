package com.example.personal_asistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onLogInClick(view: View) {
        startActivity(Intent(this, Login::class.java))
    }

    fun onSignUpClick(view: View) {
        startActivity(Intent(this, Signup::class.java))
    }
}