package com.example.androidlib.common

class Printer {

    private val default: String = "Default"

    fun print() {
        println(default)
    }

    fun printf(value: String) {
        println(value)
    }
}
