package com.example.app.extension

import retrofit2.HttpException
import java.io.IOException
import com.example.app.data.Result

class NoInternetException(message: String? = "No Internet Connection") : Exception(message)

class ServerException(message: String?) : Exception(message)

suspend fun <T : Any> safeApiCall(
    isOnline: () -> Boolean,
    call: suspend () -> T)
        : Result<T> {
    return when {
        isOnline() -> {
            try {
                val dataFromRemote = call()

                Result.Success(dataFromRemote)
            } catch (httpException: HttpException) {
                Result.Error(httpException)
            } catch (ioException: IOException) {
                Result.Error(ServerException(ioException.message))
            }
        }
        else -> Result.Error(NoInternetException())
    }
}