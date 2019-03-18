package com.example.app.data.remote.di

import com.example.app.BuildConfig.BASE_URL
import com.example.app.data.remote.AppVooService
import com.example.app.data.remote.NetworkStatus
import com.example.app.data.remote.RequestInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): AppVooService =
        retrofit.create(AppVooService::class.java)

    @Provides
    @Singleton
    fun proivideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(converterFactory)
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        requestInterceptor: RequestInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(requestInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideRequestInterceptor(): RequestInterceptor =
        RequestInterceptor()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideNetworkStatus(): NetworkStatus =
        NetworkStatus()

}