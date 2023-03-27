package com.example.androidlib.common

class Printer {

    private val default: String = "Default"

    fun print() {
        println(default)
    }

    fun printf(value: String) {
        println(value)
    }

    fun dummy(
        char: Char,
        string: String,
        numberInt: Int,
        numberLong: Long,
        list: List<String>,
        map: Map<String, String>
    ) {
        println(char)
        println(string)
        println(numberInt)
        println(numberLong)
        println(list)
        println(map)
    }
}
