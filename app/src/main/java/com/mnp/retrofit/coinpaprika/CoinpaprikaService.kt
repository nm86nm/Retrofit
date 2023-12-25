package com.mnp.retrofit.coinpaprika

import retrofit2.Call
import retrofit2.http.GET

interface CoinpaprikaService {

    @GET("coins/")
    fun getCoins(): Call<List<Coin>>
}