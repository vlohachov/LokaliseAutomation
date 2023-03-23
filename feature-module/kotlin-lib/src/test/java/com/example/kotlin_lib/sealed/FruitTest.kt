package com.example.kotlin_lib.sealed

import org.junit.Assert
import org.junit.Test

class FruitTest {

    @Test
    fun testApple() {
        Assert.assertTrue(Fruit.Apple.name == "Apple")
    }
}
