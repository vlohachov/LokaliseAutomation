package com.example.kotlinlib

import org.junit.Assert
import org.junit.Test

class SimpleMathTest {

    private val math = SimpleMath()

    @Test
    fun testSum() {
        val actual = math.sum(2, 4)
        Assert.assertTrue(actual == 6L)
    }

    @Test
    fun testSub() {
        val actual = math.sub(2, 4)
        Assert.assertTrue(actual == -2)
    }
}
