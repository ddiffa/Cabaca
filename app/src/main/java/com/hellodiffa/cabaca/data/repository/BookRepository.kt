package com.hellodiffa.cabaca.data.repository

import com.hellodiffa.cabaca.data.local.entity.book.BookEntity
import com.hellodiffa.cabaca.data.local.entity.genre.GenreEntity
import com.hellodiffa.cabaca.data.local.source.LocalDataSource
import com.hellodiffa.cabaca.data.remote.source.RemoteDataSource
import com.hellodiffa.cabaca.data.repository.base.BaseRepository

class BookRepository constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
) : BaseRepository() {


    suspend fun loadAllGenre() = singleSource(
        databaseQuery = { local.getAllGenres() },
        networkCall = { remote.getAllGenres() },
        saveCallResult = {
            local.saveAllGenres(it.resource.map { item ->
                GenreEntity(
                    genreId = item.id,
                    genreTitle = item.title
                )
            })
        }
    )

    suspend fun loadAllNewBook() = singleSource(databaseQuery = { local.getAllBooks() },
        networkCall = { remote.getNewBook() },
        saveCallResult = {
            local.saveBook(it.result.map { item ->
                BookEntity(
                    id = item.bookId,
                    title = item.title,
                    coverUrl = item.coverUrl
                )
            })
        })

    suspend fun loadBookByIdGenre(genreId: String) = remote.getBookByGenre(genreId)

    suspend fun loadBooksDetail(bookId: String) = remote.getBookDetail(466)

    suspend fun loadWriterDetail(writerId: String) = remote.getWriterDetail(writerId)
}