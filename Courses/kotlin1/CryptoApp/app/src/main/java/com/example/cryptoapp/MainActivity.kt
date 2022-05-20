package com.example.cryptoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.*
import com.example.cryptoapp.api.ApiFactory
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViwModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[CoinViwModel::class.java]
//        viewModel=ViewModelProvider(this, NewInstanceFactory())[CoinViwModel::class.java]
        viewModel.loadData()
    }

}

//www.googleapis.com/books/v1/volumes?q=harry
//1. kapt
//2. rxjava  .observeOn(AndroidSchedulers.mainThread())
//https://www.youtube.com/watch?v=aK9tOipNm0o&t=0s
