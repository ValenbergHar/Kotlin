package com.example.firebase


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView

import android.widget.EditText

import android.widget.ProgressBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider


class MainActivity : AppCompatActivity() {

    private var verificationId: String? = null
    private var progressBar: ProgressBar? = null
    private var mAuth: FirebaseAuth? = null
    private var phoneNo: EditText? = null
    private var otp: EditText? = null
    private var login: Button? = null
    private var getotp: TextView? = null
    private var otpsent: TextView? = null
    private var resendOTP: TextView? = null
    private var getotpclicked = false
    private var countdowntimer: TextView? = null
    var dialog: Dialog? = null
    var user: FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        phoneNo = findViewById(R.id.txtPhone)
        otp = findViewById(R.id.txtOtp)
        login = findViewById(R.id.btnLogin)

        login?.setOnClickListener {
            loginOnClick()
        }

    }

    private fun loginOnClick() {
        val number = phoneNo!!.text.toString().trim()
        val otp1 = otp!!.text.toString().trim()

        verifyCode(otp1);


    }

    private fun verifyCode(code: String) {
        var credential: PhoneAuthCredential =PhoneAuthProvider.getCredential()

    }
}


