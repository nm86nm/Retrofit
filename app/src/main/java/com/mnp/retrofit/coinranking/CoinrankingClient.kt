package com.mnp.retrofit.coinranking

import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun CoinrankingClient() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.coinranking.com/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val coinrankingService: CoinrankingService = retrofit.create(CoinrankingService::class.java)
    val call = coinrankingService.getCoins()
    var result = remember { mutableStateOf("temp") }

    call.enqueue(object : Callback<Coin1> {
        override fun onResponse(
            call: Call<Coin1>,
            response: Response<Coin1>
        ) {
            if (response.isSuccessful) {
                val body = response.body()

                if (body != null) {
                    body.data.coins.get(0).toString().also {
                        result.value = it
                    }          //  also the same result: result.value = body.data.coins.get(0).toString()
                    Log.i("TAG", "<OK><OK><OK>${result.value}")
                } else {
                    Log.i("TAG", "<!><!><!> coins == false")
                }
            } else {
                Log.i("TAG", "<!><!><!> response.isSuccessful == false")
            }
        }

        override fun onFailure(call: Call<Coin1>, t: Throwable) {
            Log.i("TAG", "<!><!><!> call.enqueue onFailure: " + t.localizedMessage)
        }
    })

    Text(
        text = result.value,
        fontSize = 24.sp,
        color = MaterialTheme.colors.primary
    )
}