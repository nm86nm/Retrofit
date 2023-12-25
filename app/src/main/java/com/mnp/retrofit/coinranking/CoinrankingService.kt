package com.mnp.retrofit.coinranking

import retrofit2.Call
import retrofit2.http.GET

interface CoinrankingService {
    /*@Headers(
        "X-RapidAPI-Key: d74f0314d0msh7e0ddca9c304d7ep134879jsnbbad8eacaa3e",
        "X-RapidAPI-Host: coinranking1.p.rapidapi.com"
    )
    @GET("/coins?referenceCurrencyUuid=yhjMzLPhuIDl&timePeriod=24h&tiers%5B0%5D=1&orderBy=marketCap&orderDirection=desc&limit=50&offset=0/")
    fun getCoins(): Call<List<Data>>*/

    @GET("coins/")
    fun getCoins(): Call<Coin1>
}