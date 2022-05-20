package com.example.cryptoapp


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.cryptoapp.api.ApiFactory
import com.example.cryptoapp.database.AppDatabase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class CoinViwModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)

    private val compositeDisposable = CompositeDisposable()

    val priceList = db.coinPriceInfoDao().getPriceList()
    fun loadData() {
       val disposable = ApiFactory.apiService.getTopCoinsInfo()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(
               {
                   Log.d("TEST_OF_LOADING_DATA", it.toString())
               },
               {
                   Log.d("TEST_OF_LOADING_DATA", it.message.toString())
               }
           )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}