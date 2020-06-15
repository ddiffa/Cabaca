package com.hellodiffa.cabaca.remote

import com.hellodiffa.cabaca.MockTestUtil.getResult
import com.hellodiffa.cabaca.data.remote.ApiService
import kotlinx.coroutines.runBlocking
import okio.IOException
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

class ApiServiceTest : ApiAbstract<ApiService>(){
    private lateinit var service: ApiService


    @Before
    fun `init api service`() {
        service = createService(ApiService::class.java)
    }

    @Throws(IOException::class)
    @Test
    fun `fetch genre list from network test`() = runBlocking {
        enqueueResponse("/genre.json")
        val responseBody = requireNotNull(service.getAllGenres())

        val result = getResult {
            responseBody
        }
        mockWebServer.takeRequest()

        MatcherAssert.assertThat(result.data?.resource?.size, CoreMatchers.`is`(20))
        MatcherAssert.assertThat(result.data?.resource?.get(0)?.title, CoreMatchers.`is`("Romance"))
    }

    @Test
    fun `fetch book list from network test`() = runBlocking {
        enqueueResponse("/newbook.json")
        val responseBody = requireNotNull(service.getNewBook())

        val result = getResult {
            responseBody
        }
        mockWebServer.takeRequest()

        MatcherAssert.assertThat(result.data?.result?.get(0)?.title, CoreMatchers.`is`("The Bad Guy"))
    }

    @Test
    fun `fetch detail book  from network test`() = runBlocking {
        enqueueResponse("/detailbook.json")
        val responseBody = requireNotNull(service.getBookDetail("446"))

        val result = getResult {
            responseBody
        }
        mockWebServer.takeRequest()

        MatcherAssert.assertThat(result.data?.result?.title, CoreMatchers.`is`("The Bad Guy"))
    }

    @Test
    fun `fetch detail writer  from network test`() = runBlocking {
        enqueueResponse("/detailwriter.json")
        val responseBody = requireNotNull(service.getWriterDetail("38679"))

        val result = getResult {
            responseBody
        }
        mockWebServer.takeRequest()

        MatcherAssert.assertThat(result.data?.result?.username, CoreMatchers.`is`("ami_shin"))
    }

    @Test
    fun `fetch book by genre list from network test`() = runBlocking {
        enqueueResponse("/bookbygenre.json")
        val responseBody = requireNotNull(service.getBookByGenre("38679"))

        val result = getResult {
            responseBody
        }
        mockWebServer.takeRequest()

        MatcherAssert.assertThat(result.data?.result?.get(0)?.title, CoreMatchers.`is`("Love Like Puzzle"))
    }
}