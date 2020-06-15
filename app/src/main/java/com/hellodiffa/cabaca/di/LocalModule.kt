package com.hellodiffa.cabaca.di

import androidx.room.Room
import com.hellodiffa.cabaca.data.local.CabacaDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            CabacaDatabase::class.java,
            "booksDB"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<CabacaDatabase>().bookDao()
    }

}