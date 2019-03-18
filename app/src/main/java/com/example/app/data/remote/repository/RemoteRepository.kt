package com.example.app.data.remote.repository

import com.example.app.data.Result
import com.example.app.data.model.VoosResponse
import com.example.app.data.remote.AppVooService
import com.example.app.data.remote.NetworkStatus
import com.example.app.extension.safeApiCall
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val appVooService: AppVooService,
    private val networkStatus: NetworkStatus
) {

    suspend fun getVoos(): Result<VoosResponse> {
        return safeApiCall(
            { networkStatus.isOnline() },
            { appVooService.getVoos().await() }
        )
    }
}