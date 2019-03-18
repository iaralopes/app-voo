package com.example.app.data.model

import com.google.gson.annotations.SerializedName

data class Checkout (

    @SerializedName("type") val type : String,
    @SerializedName("target") val target : String
)
