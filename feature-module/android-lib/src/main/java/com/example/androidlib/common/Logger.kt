package com.example.androidlib.common

interface Logger {

    val tag: String

    fun log(message: String)

    fun log(error: Throwable)
}
