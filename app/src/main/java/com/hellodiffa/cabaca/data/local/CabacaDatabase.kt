package com.hellodiffa.cabaca.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hellodiffa.cabaca.data.local.dao.BookDAO
import com.hellodiffa.cabaca.data.local.entity.book.BookEntity
import com.hellodiffa.cabaca.data.local.entity.genre.GenreEntity

@Database(entities = [BookEntity::class,
    GenreEntity::class], version = 1, exportSchema = false)
abstract class CabacaDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDAO
}