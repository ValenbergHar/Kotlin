package com.example.firebaseemail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    val ref = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val email = findViewById<TextInputEditText>(R.id.login_email)
//        val password = findViewById<TextInputEditText>(R.id.login_password)
//        val registerBtn = findViewById<Button>(R.id.register_button)
//
//        registerBtn.setOnClickListener {
//            ref.createUserWithEmailAndPassword(
//
//                email.text.toString().trim(),
//                password.text.toString().trim()
//            )
//        }


    }
}


// firebase connection https://www.youtube.com/watch?v=SxkKLMKTDs0
// sha1 https://www.youtube.com/watch?v=ZPrKGjGDLtY
//https://www.youtube.com/watch?v=tbh9YaWPKKs