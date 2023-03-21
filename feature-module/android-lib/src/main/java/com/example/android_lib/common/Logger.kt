package com.example.android_lib.common

interface Logger {

    fun log(message: String)

    fun log(error: Throwable)
}
