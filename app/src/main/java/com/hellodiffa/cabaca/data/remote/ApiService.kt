package com.hellodiffa.cabaca.data.remote

import com.hellodiffa.cabaca.data.remote.response.bookbygenre.BookByGenreResponse
import com.hellodiffa.cabaca.data.remote.response.bookx.BooxResponse
import com.hellodiffa.cabaca.data.remote.response.detail.DetailBookResponse
import com.hellodiffa.cabaca.data.remote.response.detailbook.BookDetailResponse
import com.hellodiffa.cabaca.data.remote.response.detailwriter.WriterDetailResponse
import com.hellodiffa.cabaca.data.remote.response.genre.GenreResponse
import com.hellodiffa.cabaca.data.remote.response.newbook.NewBookResponse
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    companion object{

        const val BASE_URL = "https://cabaca.id:8443/"
        const val BASE_URL_IMAGE ="https://cabaca.id:8443/api/v2/files/"
        const val API_KEY = "25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb"
        //https://cabaca.id:8443/api/v2/files/covers/LOVE-LIKE-PUZZLE.jpg?download=false&api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948

    }

    @GET("api/v2/cabaca/_table/genre")
    suspend fun getAllGenres() : Response<GenreResponse>

    @GET("api/v2/writer/detail/{user_id}")
    suspend fun getWriterDetail(@Path("user_id") id : String) : Response<WriterDetailResponse>

    @GET("api/v2/book/detail/{book_id}")
    suspend fun getBookDetail(@Path("book_id") id : String) : Response<DetailBookResponse>

    @GET("api/v2/book/uptodate?limit=7")
    suspend fun getNewBook() : Response<NewBookResponse>

    @GET("api/v2/book/category")
    suspend fun getBookByGenre(@Query("id") id : String) : Response<BookByGenreResponse>

}