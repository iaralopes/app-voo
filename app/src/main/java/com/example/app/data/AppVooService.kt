package com.example.app.data

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface AppVooService {

    @GET("hmg-search")
    fun getVoos(): Deferred<VoosResponse>

}