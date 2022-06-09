package com.example.firebase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class PhoneAuthentication : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    lateinit var veriBtn: Button
    lateinit var authBtn: Button
    lateinit var phnNoTxt: EditText
    lateinit var verifiTxt: EditText
    lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var progress: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mAuth = FirebaseAuth.getInstance()
        veriBtn = findViewById(R.id.veriBtn)
        authBtn = findViewById(R.id.authBtn)
        phnNoTxt = findViewById(R.id.phnNoTxt)
        verifiTxt = findViewById(R.id.verifiTxt)
        progress = findViewById(R.id.progress)

        veriBtn.setOnClickListener { view: View? -> progress.visibility = View.VISIBLE
            verify()
        }

    }

    private fun verificationCallbacks() {
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                progress.visibility = View.INVISIBLE
                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)

            }

        }
    }

    private fun verify() {

        verificationCallbacks()
        val phnNo = phnNoTxt.text.toString()
        val options =PhoneAuthOptions.newBuilder(mAuth)
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
}