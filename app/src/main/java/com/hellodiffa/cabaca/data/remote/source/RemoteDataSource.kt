package com.hellodiffa.cabaca.data.remote.source

import com.hellodiffa.cabaca.data.remote.ApiService
import com.hellodiffa.cabaca.data.remote.base.BaseDataSource

class RemoteDataSource constructor(private val apiService: ApiService) : BaseDataSource() {

    suspend fun getAllGenres() = getResult {
        apiService.getAllGenres()
    }

    suspend fun getWriterDetail(id: String) = getResult {
        apiService.getWriterDetail(id)
    }

    suspend fun getBookDetail(id: String) = getResult {
        apiService.getBookDetail(id)
    }

    suspend fun getNewBook() = getResult {
        apiService.getNewBook()
    }

    suspend fun getBookByGenre(id: String) = getResult {
        apiService.getBookByGenre(id)
    }

}