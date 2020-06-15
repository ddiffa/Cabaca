package com.hellodiffa.cabaca.di

import com.hellodiffa.cabaca.data.local.source.LocalDataSource
import com.hellodiffa.cabaca.data.remote.source.RemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { RemoteDataSource(get()) }
    single { LocalDataSource(get()) }
}