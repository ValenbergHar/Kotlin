package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val imgBtn = findViewById<ImageButton>(R.id.imageBtn)
        imgBtn.setOnClickListener {
            val intent = Intent(this, StateMainActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext, "Nia!", Toast.LENGTH_SHORT).show()
        }
    }
}