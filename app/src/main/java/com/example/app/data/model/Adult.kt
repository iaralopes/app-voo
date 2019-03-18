package com.example.app.data.model

import com.google.gson.annotations.SerializedName

data class Adult (

    @SerializedName("quantity") val quantity : Int,
    @SerializedName("fare") val fare : Double,
    @SerializedName("fees") val fees : List<Fees>
)