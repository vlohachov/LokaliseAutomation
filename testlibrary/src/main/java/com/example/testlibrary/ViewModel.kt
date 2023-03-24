package com.example.testlibrary

import com.example.kotlin_lib.sealed.Fruit
import com.example.testlibrary.domain.FindFruitUseCase
import com.example.testlibrary.domain.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

@OptIn(ExperimentalCoroutinesApi::class)
class ViewModel(private val useCase: FindFruitUseCase) {

    private val _error = MutableStateFlow<Throwable?>(value = null)
    private val _search = MutableStateFlow(value = "")

    val error: Flow<Throwable?> = _error
    val result: Flow<Result<Fruit>> = _search.flatMapLatest { search ->
        useCase.resultFlow(param = FindFruitUseCase.Param(query = search))
    }

    fun findFruit(query: String) {
        _search.value = query
    }

    fun onError(error: Throwable) {
        _error.value = error
    }

    fun onErrorConsumed() {
        _error.value = null
    }
}
