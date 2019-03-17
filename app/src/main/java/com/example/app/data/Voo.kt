package com.example.app.data


data class Voo (
    val stops : Int,
    val duration : Int,
    val from : String,
    val departureDate : String,
    val arrivalDate : String,
    val pricing : Pricing,
    val direction : String,
    val to : String
)