package com.example.firebaseemail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    lateinit var name_register: EditText
    lateinit var email_register: EditText
    lateinit var password_1_register: EditText
    lateinit var password_2_register: EditText
    lateinit var phone_register: EditText
    lateinit var register_button: Button
    lateinit var login_button: EditText
    lateinit var mAuth: FirebaseAuth
    lateinit var login_progress: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name_register = findViewById(R.id.name_register)
        email_register = findViewById(R.id.email_register)
        password_1_register = findViewById(R.id.password_1_register)
        password_2_register = findViewById(R.id.password_2_register)
        phone_register = findViewById(R.id.phone_register)
        register_button = findViewById(R.id.register_button)
        login_button = findViewById(R.id.login_button)
        mAuth = FirebaseAuth.getInstance()
        login_progress  =findViewById(R.id.login_progress)

        register_button


    }
}