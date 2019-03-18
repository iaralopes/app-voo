package com.example.app.data.model

import com.google.gson.annotations.SerializedName

data class Trips (

    @SerializedName("layover") val layover : Int,
    @SerializedName("stops") val stops : Int,
    @SerializedName("aircraft") val aircraft : String,
    @SerializedName("duration") val duration : Int,
    @SerializedName("carrier") val carrier : String,
    @SerializedName("flightNumber") val flightNumber : String,
    @SerializedName("from") val from : String,
    @SerializedName("isInternational") val isInternational : Boolean,
    @SerializedName("departureDate") val departureDate : String,
    @SerializedName("arrivalDate") val arrivalDate : String,
    @SerializedName("to") val to : String
)
