package com.hellodiffa.cabaca.data.local.source

import com.hellodiffa.cabaca.data.local.dao.BookDAO
import com.hellodiffa.cabaca.data.local.entity.book.BookEntity
import com.hellodiffa.cabaca.data.local.entity.genre.GenreEntity
import kotlinx.coroutines.flow.Flow


class LocalDataSource constructor(private val dao: BookDAO) {

    fun getAllGenres(): Flow<List<GenreEntity>> = dao.getAllGenre()

    fun getAllBooks(): Flow<List<BookEntity>> = dao.getAllBooks()


    suspend fun saveBook(book: List<BookEntity>) {
        dao.saveAllBook(book)
    }

    suspend fun saveAllGenres(genre: List<GenreEntity>) {
        dao.saveAllGenres(genre)
    }

}