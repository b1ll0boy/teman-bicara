package com.example.temanbicara.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.temanbicara.R
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.temanbicara.data.AppDb
//import com.example.temanbicara.data.AuthViewModel
import com.example.temanbicara.data.UserDatabase
//import com.example.temanbicara.data.UserRepository
//import com.example.temanbicara.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val buatAkun = findViewById<TextView>(R.id.buat_akun)
        buatAkun.setOnClickListener{
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
//            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
        }


        val login = findViewById<Button>(R.id.login)
        val inputEmail = findViewById<EditText>(R.id.input_email)
        val inputPassword = findViewById<EditText>(R.id.input_password)

        val userDao = AppDb.database.userDao()

        login.setOnClickListener{
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                userDao.getUserByEmail(email).observe(this, {user ->
                    if (user != null && user.password == password) {
                        val intent = Intent(this@LoginPage, HomePage::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
                    }  
                })

            } else {
                Toast.makeText(this, "Empty fields are not allowed!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}