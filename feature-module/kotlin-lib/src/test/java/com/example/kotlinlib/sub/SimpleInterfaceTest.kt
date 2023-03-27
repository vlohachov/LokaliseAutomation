package com.example.kotlinlib.sub

import org.junit.Assert
import org.junit.Test

class SimpleInterfaceTest {

    private val impl: MyInterface = SimpleInterface()

    @Test
    fun testValue() {
        Assert.assertTrue(impl.value == 1)
    }

    @Test
    fun testFoo() {
        Assert.assertTrue(impl.foo(4L) == "4")
    }
}
