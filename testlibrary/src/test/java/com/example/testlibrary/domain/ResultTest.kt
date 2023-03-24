package com.example.testlibrary.domain

import app.cash.turbine.test
import com.example.testlibrary.rule.TestDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ResultTest {

    @get:Rule
    val dispatcherRule = TestDispatcherRule()

    @Test
    fun testLoading() = runTest {
        flowOf<String>().asResult().test {
            Assert.assertTrue(awaitItem() is Result.Loading)
            awaitComplete()
        }
    }

    @Test
    fun testSuccess() = runTest {
        flowOf("").asResult().test {
            skipItems(count = 1)
            with(awaitItem()) {
                Assert.assertTrue(this is Result.Success)
                Assert.assertTrue((this as Result.Success).value.isBlank())
            }
            awaitComplete()
        }
    }

    @Test
    fun testError() = runTest {
        flow<String> { throw RuntimeException("error") }
            .asResult()
            .test {
                skipItems(count = 1)
                with(awaitItem()) {
                    Assert.assertTrue(this is Result.Error)
                    Assert.assertTrue((this as Result.Error).exception is RuntimeException)
                }
                awaitComplete()
            }
    }
}
