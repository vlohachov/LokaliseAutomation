package com.example.testlibrary.domain

import com.example.kotlin_lib.sealed.Fruit
import com.example.testlibrary.data.FruitDataSource
import kotlinx.coroutines.flow.Flow

class FindFruitUseCase(private val dataSource: FruitDataSource) {

    @JvmInline
    value class Param(val query: String)

    private fun execute(param: Param): Flow<Fruit> {
        return dataSource.findFruit(query = param.query)
    }

    fun resultFlow(param: Param): Flow<Result<Fruit>> =
        execute(param = param)
            .asResult()
}
