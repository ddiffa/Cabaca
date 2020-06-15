package com.hellodiffa.cabaca.data.local.entity.genre

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    indices = [Index(value = ["genreTitle"], unique = true)]
)
data class GenreEntity(
    @PrimaryKey(autoGenerate = false)
    val genreId: Long,
    val genreTitle: String,
    val bookId: Long? = null
)