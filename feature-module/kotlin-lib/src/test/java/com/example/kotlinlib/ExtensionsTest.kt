package com.example.kotlinlib

import org.junit.Assert
import org.junit.Test

class ExtensionsTest {

    @Test
    fun testBooleanAsString() {
        Assert.assertTrue(true.asString() == "true")
    }

    @Test
    fun testIntPlusFive() {
        Assert.assertTrue(6.plusTwo() == 8)
    }
}
