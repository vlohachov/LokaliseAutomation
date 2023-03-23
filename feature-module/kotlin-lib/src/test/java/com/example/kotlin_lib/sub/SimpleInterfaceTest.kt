package com.example.kotlin_lib.sub

import org.junit.Assert
import org.junit.Test

class SimpleInterfaceTest {

//    private val impl: MyInterface = object : MyInterface {
//        override val value: Int
//            get() = 20
//
//        override fun foo(param: Long): String {
//            return param.toString()
//        }
//    }

    private val impl: MyInterface = SimpleInterface()

    @Test
    fun testValue() {
        Assert.assertTrue(impl.value == 20)
    }

    @Test
    fun testFoo() {
        Assert.assertTrue(impl.foo(4L) == "4")
    }
}
