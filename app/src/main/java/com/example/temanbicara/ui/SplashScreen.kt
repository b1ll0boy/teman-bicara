package com.example.temanbicara.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.temanbicara.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val logo = findViewById<ImageView>(R.id.logo)
        logo.alpha = 0f
        logo.animate().setDuration(1500).alpha(1f).withEndAction {
            val i = Intent(this, LoginPage::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out)
            finish()
        }
    }
}