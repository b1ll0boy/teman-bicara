package com.example.temanbicara.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.temanbicara.R
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.Toast
import com.example.temanbicara.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val textClick = findViewById<TextView>(R.id.buat_akun)
//        textClick.setOnClickListener{
//            val intent = Intent(this, RegisterPage::class.java)
//            startActivity(intent)
//            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
//        }

//        val buttonClick = findViewById<Button>(R.id.login)
//        buttonClick.setOnClickListener {
//            val intent = Intent(this, HomePage::class.java)
//            startActivity(intent)
//            overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out)
//        }

        firebaseAuth = FirebaseAuth.getInstance()
        binding.buatAkun.setOnClickListener{
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }

        binding.login.setOnClickListener{
            val email = binding.inputEmail.text.toString()
            val password = binding.inputPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener() {
                    if (it.isSuccessful) {
                        val intent = Intent(this@LoginPage, HomePage::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty fields Are not Allowed!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}