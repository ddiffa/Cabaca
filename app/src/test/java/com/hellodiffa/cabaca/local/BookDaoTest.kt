package com.hellodiffa.cabaca.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import com.hellodiffa.cabaca.MockTestUtil
import com.hellodiffa.cabaca.data.local.dao.BookDAO
import kotlinx.coroutines.runBlocking
import okio.IOException
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class BookDaoTest : LocalDatabase() {

    private lateinit var dao: BookDAO

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        dao = db.bookDao()
    }

    @Test
    @Throws(IOException::class)
    fun `insert and get genre data from DB`() = runBlocking {
        val mockGenreLocal = MockTestUtil.mockGenreLocal()
        dao.saveAllGenres(mockGenreLocal)

        var list = dao.getAllGenre().asLiveData().getValueBlocking()

        assertThat(list.toString(), `is`(mockGenreLocal.toString()))
        assertThat(list?.get(0)?.toString(), `is`(mockGenreLocal[0].toString()))

        val mockDataLocal = MockTestUtil.mockBookLocal()
        dao.saveAllBook(mockDataLocal)

        var listBook = dao.getAllBooks().asLiveData().getValueBlocking()

        assertThat(listBook.toString(), `is`(mockDataLocal.toString()))
        assertThat(listBook?.get(0)?.toString(), `is`(mockDataLocal[0].toString()))
    }


}