package com.hellodiffa.cabaca

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class MainCoroutinesRule : TestRule, TestCoroutineScope by TestCoroutineScope() {

    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    override fun apply(base: Statement?, description: Description?): Statement {
       return object : Statement() {
            override fun evaluate() {
                Dispatchers.setMain(testCoroutineDispatcher)
                base?.evaluate()
                Dispatchers.resetMain()
            }
        }
    }
}