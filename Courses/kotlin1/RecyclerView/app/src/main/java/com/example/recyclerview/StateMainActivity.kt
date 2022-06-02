package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class StateMainActivity : AppCompatActivity() {

    private var btnPolackaeKniastva: Button? = null
    private var btnVKL: Button? = null
    private var btnXIII: Button? = null
    private var btnXIV: Button? = null
    private var btnXV: Button? = null
    private var btnXVI: Button? = null

    private var btnRP: Button? = null
    private var btnXVIr: Button? = null
    private var btnXVII: Button? = null
    private var btnXVIII: Button? = null


    private var btnRusOcc: Button? = null
    private var btnBNR: Button? = null
    private var btnZahBiel: Button? = null
    private var btnBSSRFirst: Button? = null
    private var btnNacOcc: Button? = null
    private var btnBSSRSecond: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_main)
        supportActionBar!!.hide()

        btnPolackaeKniastva = findViewById(R.id.btnPolackKniastva)
        btnVKL = findViewById(R.id.btnVKL)
        btnXIII = findViewById(R.id.btnXIII)
        btnXIV = findViewById(R.id.btnXIV)
        btnXV = findViewById(R.id.btnXV)
        btnXVI = findViewById(R.id.btnXVI)



        btnRP = findViewById(R.id.btnRP)
        btnXVIr = findViewById(R.id.btnXVIr)
        btnXVII = findViewById(R.id.btnXVII)
        btnXVIII = findViewById(R.id.btnXVIII)


        btnRusOcc = findViewById(R.id.btnRusOcc)
        btnBNR = findViewById(R.id.btnBNR)
        btnZahBiel = findViewById(R.id.btnZahBiel)
        btnBSSRFirst = findViewById(R.id.btnBSSRFirst)
        btnNacOcc = findViewById(R.id.btnNacOcc)
        btnBSSRSecond = findViewById(R.id.btnBSSRSecond)


        btnVKL?.setOnClickListener {
            btnXIII?.visibility = View.VISIBLE
            btnXIV?.visibility = View.VISIBLE
            btnXV?.visibility = View.VISIBLE
            btnXVI?.visibility = View.VISIBLE
        }

        btnRP?.setOnClickListener {
            btnXVIr?.visibility = View.VISIBLE
            btnXVII?.visibility = View.VISIBLE
            btnXVIII?.visibility = View.VISIBLE
        }







    }
}