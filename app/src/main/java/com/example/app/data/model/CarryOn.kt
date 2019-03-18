package com.example.app.data.model

import com.google.gson.annotations.SerializedName

data class CarryOn (

    @SerializedName("weight") val weight : Int,
    @SerializedName("prices") val prices : List<Int>
)