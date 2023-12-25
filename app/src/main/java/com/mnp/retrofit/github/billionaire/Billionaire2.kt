package com.mnp.retrofit.github.billionaire


import com.google.gson.annotations.SerializedName

data class Billionaire2(
    @SerializedName("age")
    val age: String,
    @SerializedName("country/territory")
    val countryterritory: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("industry")
    val industry: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("networth")
    val networth: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("source")
    val source: String
)