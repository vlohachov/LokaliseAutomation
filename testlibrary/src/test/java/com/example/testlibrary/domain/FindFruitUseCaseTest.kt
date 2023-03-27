package com.example.testlibrary.domain

import app.cash.turbine.test
import com.example.kotlinlib.sealed.Fruit
import com.example.testlibrary.data.FruitDataSource
import com.example.testlibrary.rule.TestDispatcherRule
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FindFruitUseCaseTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    private val dataSource = mockk<FruitDataSource>(relaxed = true)

    private val useCase = FindFruitUseCase(dataSource = dataSource)

    @Test
    fun testResultFlowLoading() = runTest {
        useCase.resultFlow(param = FindFruitUseCase.Param(query = "")).test {
            Assert.assertTrue(awaitItem() is Result.Loading)
            awaitComplete()
        }
    }

    @Test
    fun testResultFlowSuccess() = runTest {
        every { dataSource.findFruit(query = any()) } returns flowOf(value = Fruit.Apple)
        useCase.resultFlow(param = FindFruitUseCase.Param(query = "")).test {
            skipItems(count = 1)
            with(awaitItem()) {
                Assert.assertTrue(this is Result.Success)
                Assert.assertTrue((this as Result.Success).value is Fruit.Apple)
            }
            awaitComplete()
        }
    }

    @Test
    fun testResultFlowError() = runTest {
        every { dataSource.findFruit(query = any()) } returns flow { throw NoSuchElementException() }
        useCase.resultFlow(param = FindFruitUseCase.Param(query = "")).test {
            skipItems(count = 1)
            with(awaitItem()) {
                Assert.assertTrue(this is Result.Error)
                Assert.assertTrue((this as Result.Error).exception is NoSuchElementException)
            }
            awaitComplete()
        }
    }
}
