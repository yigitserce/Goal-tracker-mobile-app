package com.example.personal_asistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Goals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals)

        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
    }

    fun onLogOutClick(view: View) {
        startActivity(Intent(this, Login::class.java))
    }
}