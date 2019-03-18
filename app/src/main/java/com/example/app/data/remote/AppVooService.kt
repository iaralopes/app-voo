package com.example.app.data.remote

import com.example.app.data.model.VoosResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface AppVooService {

    @GET("hmg-search")
    fun getVoos(): Deferred<VoosResponse>

}