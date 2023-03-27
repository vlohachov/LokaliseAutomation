package com.example.kotlinlib.sub

class SimpleInterface : MyInterface {
    override val value: Int
        get() = 1

    override fun foo(param: Long): String {
        return param.toString()
    }
}
