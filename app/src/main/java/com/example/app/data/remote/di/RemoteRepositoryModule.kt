package com.example.app.data.remote.di

import com.example.app.data.remote.AppVooService
import com.example.app.data.remote.NetworkStatus
import com.example.app.data.remote.repository.RemoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteRepositoryModule {

    @Provides
    @Singleton
    fun provideRemoteInspectionRepository(appVooService: AppVooService, networkStatus: NetworkStatus): RemoteRepository =
        RemoteRepository(appVooService, networkStatus)
}