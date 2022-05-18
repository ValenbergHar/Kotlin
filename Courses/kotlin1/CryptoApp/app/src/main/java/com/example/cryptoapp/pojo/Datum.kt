package com.example.cryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum(
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinInfo?= null
)