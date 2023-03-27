package com.example.testlibrary.data

import app.cash.turbine.test
import com.example.kotlinlib.sealed.Fruit
import com.example.testlibrary.rule.TestDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FruitDataSourceTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    private val fruits = listOf(Fruit.Apple, Fruit.Grape, Fruit.Lemon)
    private val dataSource = FruitDataSource(data = fruits)

    @Test
    fun testLoadFruits() = runTest {
        dataSource.loadFruits().test {
            val actual = awaitItem()

            Assert.assertTrue(actual.isNotEmpty())
            Assert.assertTrue(actual.size == fruits.size)

            awaitComplete()
        }
    }

    @Test
    fun testFindFruitSuccess() = runTest {
        dataSource.findFruit(query = Fruit.Apple.name).test {
            Assert.assertTrue(awaitItem() is Fruit.Apple)
            awaitComplete()
        }
    }

    @Test
    fun testFindFruitError() = runTest {
        dataSource.findFruit(query = "").test {
            Assert.assertTrue(awaitError() is NoSuchElementException)
        }
    }
}
