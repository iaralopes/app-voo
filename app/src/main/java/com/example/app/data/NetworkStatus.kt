package com.example.app.data

import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class NetworkStatus {

    fun isOnline(): Boolean {
        return try {
            val timeoutMs = 1500
            val sock = Socket()
            val sockaddr = InetSocketAddress("8.8.8.8", 53)

            sock.connect(sockaddr, timeoutMs)
            sock.close()

            true
        } catch (e: IOException) {
            false
        }
    }
}