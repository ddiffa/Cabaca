package com.hellodiffa.cabaca

import android.accounts.NetworkErrorException
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.data.local.entity.book.BookEntity
import com.hellodiffa.cabaca.data.local.entity.genre.GenreEntity
import com.hellodiffa.cabaca.data.remote.response.genre.ResourceItem
import com.squareup.moshi.Json
import okio.IOException
import retrofit2.Response
import java.util.concurrent.TimeoutException

object MockTestUtil {





    fun mockGenreLocal() = listOf(
        GenreEntity(
            genreId = 1,
            genreTitle = "romance",
            bookId = 2
        )
    )

    fun mockBookLocal() = listOf(
        BookEntity(
            id = 1,
            title = "Hitman",
            coverUrl = "hitman.jpg"
        )
    )



    suspend fun <T> getResult(call: suspend () -> Response<T>): ResultState<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return ResultState.success(body)
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return when (e) {
                is IOException -> error<T>("No Internet Connection!")
                is TimeoutException -> error("Connection Timeout!")
                is NetworkErrorException -> error("Network Error!")
                else -> error(e.message ?: e.toString())
            }
        }
    }


    private fun <T> error(message: String): ResultState<T> = ResultState.error(message = message)
}