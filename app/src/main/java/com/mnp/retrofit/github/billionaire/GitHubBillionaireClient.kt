package com.mnp.retrofit.github.billionaire

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
fun GitHubBillionaireClient() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/nm86nm/json/main/billionaire/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val billionaireService: BillionaireService = retrofit.create(BillionaireService::class.java)
    val call = billionaireService.getBillionaires()
    var result = remember { mutableStateOf("temp") }

    call.enqueue(object : Callback<List<Billionaire>> {
        override fun onResponse(
            call: Call<List<Billionaire>>,
            response: Response<List<Billionaire>>
        ) {
            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {
                    result.value = body.get(0).toString()
                    Log.i("TAG", "<OK><OK><OK>${result.value}")
                } else {
                    Log.i("TAG", "<!><!><!> body == false")
                }
            } else {
                Log.i("TAG", "<!><!><!> response.isSuccessful == false")
                result.value = "response.isSuccessful == false"
            }
        }

        override fun onFailure(call: Call<List<Billionaire>>, t: Throwable) {
            Log.i("TAG", "<!><!><!> call.enqueue onFailure: " + t.localizedMessage)
            result.value = "call.enqueue onFailure" + t.localizedMessage
        }
    })

    Text(
        text = result.value,
        fontSize = 24.sp,
        color = MaterialTheme.colors.primary
    )
}