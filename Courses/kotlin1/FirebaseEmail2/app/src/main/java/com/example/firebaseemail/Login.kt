package com.example.firebaseemail

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    lateinit var email_login: EditText
    lateinit var password_login: EditText
    lateinit var login_login_button: Button
    lateinit var login_registration_button: Button
    lateinit var login_forgot: Button
    lateinit var mAuth: FirebaseAuth
    lateinit var login_progress: ProgressBar
    lateinit var resetMail: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_login = findViewById(R.id.email_login)
        password_login = findViewById(R.id.password_login)
        login_login_button = findViewById(R.id.login_login_button)
        login_forgot = findViewById(R.id.login_forgot)
        login_registration_button = findViewById(R.id.login_registration_button)
        login_progress = findViewById(R.id.login_progress)
        mAuth = FirebaseAuth.getInstance()


        login_registration_button.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }

        login_login_button.setOnClickListener {
            var email = email_login.text.toString().trim()
            var password = password_login.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext, "Email is Required", Toast.LENGTH_LONG).show()
                email_login.error = "Email is Required"

            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(applicationContext, "Password is Required", Toast.LENGTH_LONG).show()
            }
            login_progress.visibility = View.VISIBLE

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "Logged", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Error " + task.exception.toString(), Toast.LENGTH_LONG
                    ).show()
                }
            }
        }


        login_forgot.setOnClickListener { it ->

            resetMail = EditText(it.context)
            val passwordResetDialog = AlertDialog.Builder(it.context)
            passwordResetDialog.setTitle("Reset Password?")
            passwordResetDialog.setMessage("Enter Your Email To Receive Reset Ling.")
            passwordResetDialog.setView(resetMail)

            passwordResetDialog.setPositiveButton(
                "YES", DialogInterface.OnClickListener{ dialog, id ->positiveButtonClick() })
            passwordResetDialog.setNegativeButton(
                "NO", DialogInterface.OnClickListener{dialog, id ->negativeButtonClick() }
            )


            passwordResetDialog.create().show()
        }


    }

    private fun negativeButtonClick() {


    }



    private fun positiveButtonClick() {
        val mail: String = resetMail.text.toString()
        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener {
            Toast.makeText(applicationContext, "Reset link Sent To Your Email", Toast.LENGTH_LONG).show()
        }.addOnFailureListener{
            Toast.makeText(applicationContext, "Error!", Toast.LENGTH_LONG).show()
        }
    }
}


