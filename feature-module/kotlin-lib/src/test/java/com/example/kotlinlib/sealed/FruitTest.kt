package com.example.kotlinlib.sealed

import org.junit.Assert
import org.junit.Test

class FruitTest {

    @Test
    fun testApple() {
        Assert.assertTrue(Fruit.Apple.name == "Apple")
    }
}
