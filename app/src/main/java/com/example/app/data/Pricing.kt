package com.example.app.data

import com.google.gson.annotations.SerializedName

data class Pricing (

    @SerializedName("ota") val ota : Ota? = null,
    @SerializedName("airlineName") val airlineName : String,
    @SerializedName("isInternational") val isInternational : Boolean,
    @SerializedName("bestPriceAt") val bestPriceAt : String,
    @SerializedName("mmBestPriceAt") val mmBestPriceAt : String,
    @SerializedName("savingPercentage") val savingPercentage : Double
)
