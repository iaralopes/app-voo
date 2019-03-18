package com.example.app.data.model

import com.google.gson.annotations.SerializedName

data class Fees (

    @SerializedName("type") val type : String,
    @SerializedName("value") val value : Double,
    @SerializedName("group") val group : String,
    @SerializedName("passengerType") val passengerType : String
)