package com.example.temanbicara.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.temanbicara.R
import com.example.temanbicara.data.AppDb
//import com.example.temanbicara.data.AuthViewModel
import com.example.temanbicara.data.User
import com.example.temanbicara.data.UserDatabase
//import com.example.temanbicara.data.UserRepository
//import com.example.temanbicara.databinding.ActivityRegisterPageBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)


        val registerButton = findViewById<Button>(R.id.registerButton)
        val inputNama = findViewById<EditText>(R.id.input_nama)
        val inputEmail = findViewById<EditText>(R.id.input_email)
        val inputPassword = findViewById<EditText>(R.id.input_password)
        val confirmPassword = findViewById<EditText>(R.id.confirm_password)
        val inputTelepon = findViewById<EditText>(R.id.input_telepon)

        registerButton.setOnClickListener{
            val name = inputNama.text.toString()
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            val confirmPassword = confirmPassword.text.toString()
            val phone = inputTelepon.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    val userDao = AppDb.database.userDao()
                    val user = User(name = name, email = email, password = password)

                    CoroutineScope(Dispatchers.IO).launch {
                        userDao.insert(user)
                    }

                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

//                    authViewModel.registerUser(user)
                    val intent = Intent(this@RegisterPage, LoginPage::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty fields are not allowed!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}