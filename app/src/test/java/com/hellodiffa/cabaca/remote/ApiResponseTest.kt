package com.hellodiffa.cabaca.remote

import com.hellodiffa.cabaca.common.ResultState
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ApiResponseTest {
    @Test
    fun `response error exception`() {
        val exception = Exception("foo")
        val apiResponse = ResultState.error<String>(exception.message)
        MatcherAssert.assertThat(apiResponse.message, CoreMatchers.`is`("foo"))
    }

    @Test
    fun `response success`() {
        val apiResponse = ResultState.success<String>("foo")
        MatcherAssert.assertThat(apiResponse.data, CoreMatchers.`is`("foo"))
    }
}