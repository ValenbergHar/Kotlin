package com.example.firebaseemail

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    lateinit var name_register: EditText
    lateinit var email_register: EditText
    lateinit var password_1_register: EditText
    lateinit var password_2_register: EditText
    lateinit var phone_register: EditText
    lateinit var register_button: Button
    lateinit var register_login_button: Button
    lateinit var mAuth: FirebaseAuth
    lateinit var register_progress: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name_register = findViewById(R.id.name_register)
        email_register = findViewById(R.id.email_register)
        password_1_register = findViewById(R.id.password_1_register)
        password_2_register = findViewById(R.id.password_2_register)
        phone_register = findViewById(R.id.phone_register)
        register_button = findViewById(R.id.register_button)
        register_login_button = findViewById(R.id.register_login_button)
        mAuth = FirebaseAuth.getInstance()
        register_progress = findViewById(R.id.register_progress)


        if (mAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        register_login_button.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }


        register_button.setOnClickListener {
            var email = email_register.text.toString().trim()
            var password1 = password_1_register.text.toString().trim()
            var password2 = password_2_register.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext, "Email is Required", Toast.LENGTH_LONG).show()
                email_register.error = "Email is Required"

            }
            if (TextUtils.isEmpty(password1)) {
                Toast.makeText(applicationContext, "Password is Required", Toast.LENGTH_LONG).show()
            }

            if (TextUtils.isEmpty(password2)) {
                Toast.makeText(applicationContext, "Password", Toast.LENGTH_LONG).show()
            }

            if (password1.length < 6) {
                Toast.makeText(
                    applicationContext,
                    "Passwords must be >=6 characters",
                    Toast.LENGTH_LONG
                )
                    .show()
            }

            if (password1 != password2) {
                Toast.makeText(applicationContext, "Passwords don`t match", Toast.LENGTH_LONG)
                    .show()
            }
            register_progress.visibility = View.VISIBLE


            mAuth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "User Created", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Error " + task.exception.toString(), Toast.LENGTH_LONG
                    ).show()
                }

            }

        }
    }


}