package com.example.android_lib.common

interface Logger {

    val tag: String

    fun log(message: String)

    fun log(error: Throwable)
}
