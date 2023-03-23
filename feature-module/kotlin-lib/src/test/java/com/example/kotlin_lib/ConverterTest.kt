package com.example.kotlin_lib

import org.junit.Assert
import org.junit.Test

class ConverterTest {

    @Test
    fun testInt() {
        val actual = Converter.toString(int = 2)
        Assert.assertTrue(actual == "2")
    }

    @Test
    fun testLong() {
        val actual = Converter.toString(long = 2L)
        Assert.assertTrue(actual == "2")
    }
}
