package com.example.firebaseemail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    val ref = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun logout(view: View){
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, Login::class.java))
        finish()
    }
}


// firebase connection https://www.youtube.com/watch?v=SxkKLMKTDs0
// sha1 https://www.youtube.com/watch?v=ZPrKGjGDLtY
//https://www.youtube.com/watch?v=tbh9YaWPKKs