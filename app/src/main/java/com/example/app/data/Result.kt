package com.example.app.data

sealed class Result<out T> {

    class Success<T>(val data: T) : Result<T>()
    class Error(val exception: Throwable) : Result<Nothing>()
}