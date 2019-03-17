package com.example.app.data

import com.google.gson.annotations.SerializedName

data class Ota (

    @SerializedName("adult") val adult : Adult,
    @SerializedName("luggage") val luggage : Luggage,
    @SerializedName("checkout") val checkout : Checkout,
    @SerializedName("familyCode") val familyCode : String,
    @SerializedName("fareTotal") val fareTotal : Double,
    @SerializedName("saleTotal") val saleTotal : Double
)
