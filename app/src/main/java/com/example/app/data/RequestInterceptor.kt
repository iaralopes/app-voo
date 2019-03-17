package com.example.app.data

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class RequestInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val builder = original.newBuilder()
        builder.header("Content-Type", "application/json")
        builder.method(original.method(), original.body())

        val newRequest = builder.build()

        return chain.proceed(newRequest)
    }

}