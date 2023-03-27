package com.example.testlibrary.data

import com.example.kotlinlib.sealed.Fruit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class FruitDataSource(private val data: List<Fruit>) {

    fun loadFruits(): Flow<List<Fruit>> = flowOf(data)

    fun findFruit(query: String): Flow<Fruit> = flow {
        emit(
            data.find { fruit -> fruit.name == query }
            ?: throw NoSuchElementException()
        )
    }
}
