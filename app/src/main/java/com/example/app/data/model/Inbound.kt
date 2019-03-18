package com.example.app.data.model

import com.google.gson.annotations.SerializedName

data class Inbound (

    @SerializedName("stops") val stops : Int,
    @SerializedName("airline") val airline : String,
    @SerializedName("otaAvailableIn") val otaAvailableIn : String,
    @SerializedName("duration") val duration : Int,
    @SerializedName("flightNumber") val flightNumber : String,
    @SerializedName("airlineTarget") val airlineTarget : String,
    @SerializedName("from") val from : String,
    @SerializedName("id") val id : String,
    @SerializedName("choosedTripType") val choosedTripType : String,
    @SerializedName("availableIn") val availableIn : String,
    @SerializedName("trips") val trips : List<Trips>,
    @SerializedName("departureDate") val departureDate : String,
    @SerializedName("arrivalDate") val arrivalDate : String,
    @SerializedName("cabin") val cabin : String,
    @SerializedName("pricing") val pricing : Pricing,
    @SerializedName("direction") val direction : String,
    @SerializedName("to") val to : String
)