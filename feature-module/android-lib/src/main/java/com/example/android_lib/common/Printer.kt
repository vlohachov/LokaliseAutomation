package com.example.android_lib.common

class Printer {

    private val default: String = "Default"

    fun print() {
        println(default)
    }

    fun printf(value: String) {
        println(value)
    }
}
