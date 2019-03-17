package com.example.app.data

import com.google.gson.annotations.SerializedName

data class Luggage (

    @SerializedName("carryOn") val carryOn : CarryOn,
    @SerializedName("checked") val checked : Checked
)
