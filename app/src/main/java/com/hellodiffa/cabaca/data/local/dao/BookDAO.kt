package com.hellodiffa.cabaca.data.local.dao

import androidx.room.*
import com.hellodiffa.cabaca.data.local.entity.book.BookEntity
import com.hellodiffa.cabaca.data.local.entity.genre.GenreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllGenres(genre: List<GenreEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllBook(book: List<BookEntity>)

    @Query("SELECT * FROM genreentity")
    fun getAllGenre(): Flow<List<GenreEntity>>

    @Query("SELECT * FROM bookentity")
    fun getAllBooks() : Flow<List<BookEntity>>
}