package com.mnp.retrofit.github.billionaire

import retrofit2.Call
import retrofit2.http.GET

interface BillionaireService {

    @GET("billionaire.json")
    fun getBillionaires(): Call<List<Billionaire>>
}