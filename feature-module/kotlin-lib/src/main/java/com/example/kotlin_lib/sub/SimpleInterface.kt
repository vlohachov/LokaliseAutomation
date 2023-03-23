package com.example.kotlin_lib.sub

class SimpleInterface : MyInterface {
    override val value: Int
        get() = 20

    override fun foo(param: Long): String {
        return param.toString()
    }
}
