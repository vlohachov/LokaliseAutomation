package com.example.kotlinlib.sealed

sealed class Fruit(val name: String) {
    object Apple : Fruit(name = "Apple")
    object Orange : Fruit(name = "Orange")
    object Grape : Fruit(name = "Grape")
    object Lemon : Fruit(name = "Lemon")
}
