package com.mnp.retrofit.github.billionaire

import com.google.gson.annotations.SerializedName

data class Billionaire(
    val id: String,
    @SerializedName("country/territory")
    val countryterritory: String,
    val rank: String,
    val name: String,
    val networth: String,
    val age: String,
    val source: String,
    val industry: String
)

/*
{
        "age": 74,
        "country/territory": "France",
        "id": 1,
        "industry": "Fashion & Retail",
        "name": "Bernard Arnault & family",
        "networth": "$211 B",
        "rank": 1,
        "source": "LVMH"
    }
 */