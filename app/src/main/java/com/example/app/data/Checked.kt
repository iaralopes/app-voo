package com.example.app.data

import com.google.gson.annotations.SerializedName

data class Checked (

    @SerializedName("weight") val weight : String,
    @SerializedName("prices") val prices : List<String>
)
