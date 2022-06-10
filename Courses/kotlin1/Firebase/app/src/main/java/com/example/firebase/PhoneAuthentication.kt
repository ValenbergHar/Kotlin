package com.example.firebase

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class PhoneAuthentication : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var veriBtn: Button
    lateinit var authBtn: Button
    lateinit var phnNoTxt: EditText
    lateinit var verifiTxt: EditText
    lateinit var progress: ProgressBar
    var verificationId =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mAuth = FirebaseAuth.getInstance()
        veriBtn = findViewById(R.id.veriBtn)
        authBtn = findViewById(R.id.authBtn)
        phnNoTxt = findViewById(R.id.phnNoTxt)
        verifiTxt = findViewById(R.id.verifiTxt)
        progress = findViewById(R.id.progress)

        veriBtn.setOnClickListener { view: View? ->
            progress.visibility = View.VISIBLE
            verify()
        }
        authBtn.setOnClickListener { view: View? ->
            progress.visibility = View.INVISIBLE
            authenticate()
        }

    }

    private fun authenticate() {
        val verifiNo = verifiTxt.text.toString()
        val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(verificationId, verifiNo)
        signIn(credential)
    }

    private fun verificationCallbacks() {
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted")
                progress.visibility = View.INVISIBLE
                signIn(credential)


            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.w(TAG, "onVerificationFailed", e)
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)
                verificationId = p0.toString()
                progress.visibility = View.INVISIBLE

            }

        }
    }

    private fun signIn(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                toast("Logged in Successfully :)")
                startActivity(Intent(this, MainActivity::class.java))
                Log.d(TAG, "signInWithCredential:success")

            } else {
                // Sign in failed, display a message and update the UI
                Log.w(TAG, "signInWithCredential:failure", task.exception)
                if (task.exception is FirebaseAuthInvalidCredentialsException) {
                    // The verification code entered was invalid
                }
                // Update UI
            }

        }
    }

    private fun verify() {

        verificationCallbacks()
        val phnNo = phnNoTxt.text.toString()
        val options = PhoneAuthOptions.newBuilder(mAuth)
            .setPhoneNumber(phnNo)
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)


//        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//            phnNo,
//            60,
//            TimeUnit.SECONDS,
//            this,
//            mCallbacks
//        )
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}