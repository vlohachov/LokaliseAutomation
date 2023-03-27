package com.example.testlibrary

import app.cash.turbine.test
import com.example.kotlinlib.sealed.Fruit
import com.example.testlibrary.domain.FindFruitUseCase
import com.example.testlibrary.domain.Result
import com.example.testlibrary.rule.TestDispatcherRule
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ViewModelTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    private val useCase = mockk<FindFruitUseCase>(relaxed = true)

    private lateinit var viewModel: ViewModel

    @Before
    fun setUp() {
        viewModel = ViewModel(useCase = useCase)
    }

    @Test
    fun testInitial() = runTest {
        viewModel.error.test {
            Assert.assertNull(awaitItem())
        }
    }

    @Test
    fun testOnError() = runTest {
        val expected = RuntimeException("Ooops")
        viewModel.onError(expected)
        viewModel.error.test {
            val actual = awaitItem()
            Assert.assertNotNull(actual)
            Assert.assertEquals(expected, actual)
        }
    }

    @Test
    fun testOnErrorConsumed() = runTest {
        val expected = RuntimeException("Ooops")
        viewModel.onError(expected)
        viewModel.error.test {
            Assert.assertNotNull(awaitItem())

            viewModel.onErrorConsumed()

            Assert.assertNull(awaitItem())
        }
    }

    @Test
    fun testFindFruitLoading() = runTest {
        every {
            useCase.resultFlow(any())
        } returns flowOf(Result.Loading)
        viewModel.result.test {
            Assert.assertTrue(awaitItem() is Result.Loading)
        }
    }

    @Test
    fun testFindFruitSuccess() = runTest {
        every {
            useCase.resultFlow(any())
        } returns flowOf(Result.Success(value = Fruit.Apple))
        viewModel.result.test {
            skipItems(count = 1)
            viewModel.findFruit(query = "Apple")
            with(awaitItem()) {
                Assert.assertTrue(this is Result.Success)
                Assert.assertTrue((this as Result.Success).value is Fruit.Apple)
            }
        }
    }

    @Test
    fun testFindFruitError() = runTest {
        every {
            useCase.resultFlow(any())
        } returns flowOf(Result.Error(exception = NoSuchElementException()))
        viewModel.result.test {
            skipItems(count = 1)
            viewModel.findFruit(query = "Apple")
            with(awaitItem()) {
                Assert.assertTrue(this is Result.Error)
                Assert.assertTrue((this as Result.Error).exception is NoSuchElementException)
            }
        }
    }
}
