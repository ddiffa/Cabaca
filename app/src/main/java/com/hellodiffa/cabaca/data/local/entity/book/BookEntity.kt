package com.hellodiffa.cabaca.data.local.entity.book

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val title: String,
    val coverUrl: String
)