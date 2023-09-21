package com.example.temanbicara.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.temanbicara.R

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        val textClick = findViewById<Button>(R.id.register)
        textClick.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }
    }
}