package com.example.app.data

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