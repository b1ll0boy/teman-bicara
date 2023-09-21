package com.example.temanbicara.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.temanbicara.R
import android.text.method.LinkMovementMethod
import android.widget.Button

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val textClick = findViewById<TextView>(R.id.buat_akun)
        textClick.setOnClickListener{
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)

        }

        val buttonClick = findViewById<Button>(R.id.login)
        buttonClick.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }
    }
}