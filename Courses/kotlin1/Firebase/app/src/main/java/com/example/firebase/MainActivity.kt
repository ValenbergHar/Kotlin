package com.example.firebase


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val imgBtn = findViewById<ImageButton>(R.id.imageBtn)
        imgBtn.setOnClickListener {

        }
    }
}