package com.mnp.retrofit.coinpaprika

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
fun CoinpaprikaClient() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.coinpaprika.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val coinpaprikaService: CoinpaprikaService = retrofit.create(CoinpaprikaService::class.java)
    val call = coinpaprikaService.getCoins()
    var result = remember { mutableStateOf("temp") }

    call.enqueue(object : Callback<List<Coin>> {
        override fun onResponse(
            call: Call<List<Coin>>,
            response: Response<List<Coin>>
        ) {
            if (response.isSuccessful) {
                val body = response.body()

                if (body != null) {
                    result.value = body.get(0).toString()
                    Log.i("TAG", "<OK><OK><OK>${result.value}")
                } else {
                    Log.i("TAG", "<!><!><!> coins == false")
                }
            } else {
                Log.i("TAG", "<!><!><!> response.isSuccessful == false")
            }
        }

        override fun onFailure(call: Call<List<Coin>>, t: Throwable) {
            Log.i("TAG", "<!><!><!> call.enqueue onFailure: " + t.localizedMessage)
        }
    })

    Text(
        text = result.value,
        fontSize = 24.sp,
        color = MaterialTheme.colors.primary
    )
}