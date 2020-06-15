package com.hellodiffa.cabaca.di

import com.hellodiffa.cabaca.data.repository.BookRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { BookRepository(get(), get()) }
}