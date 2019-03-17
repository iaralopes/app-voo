package com.example.app.data

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