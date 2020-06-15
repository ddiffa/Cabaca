package com.hellodiffa.cabaca.data.remote

import com.hellodiffa.cabaca.data.remote.response.bookbygenre.BookByGenreResponse
import com.hellodiffa.cabaca.data.remote.response.detailbook.BookDetailResponse
import com.hellodiffa.cabaca.data.remote.response.detailwriter.WriterDetailResponse
import com.hellodiffa.cabaca.data.remote.response.genre.GenreResponse
import com.hellodiffa.cabaca.data.remote.response.newbook.NewBookResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    companion object{

        const val BASE_URL = "https://cabaca.id:8443/api/v2/"
        const val BASE_URL_IMAGE ="https://cabaca.id:8443/api/v2/files/"

        //https://cabaca.id:8443/api/v2/files/covers/LOVE-LIKE-PUZZLE.jpg?download=false&api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948
    }

    @GET("cabaca/_table/genre")
    fun getAllGenres() : Response<GenreResponse>

    @GET("writer/detail/{id}")
    fun getWriterDetail(@Path("id") id : String) : Response<WriterDetailResponse>

    @GET("book/detail/{id}")
    fun getBookDetail(@Path("id") id : String) : Response<BookDetailResponse>

    @GET("book/uptodate?limit=7")
    fun getNewBook() : Response<NewBookResponse>

    @GET("book/category")
    fun getBookByGenre(@Query("id") id : String) : Response<BookByGenreResponse>

}