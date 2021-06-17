package com.hellodiffa.cabaca.di

import com.hellodiffa.cabaca.ui.feature.bookdetail.BookDetailViewModel
import com.hellodiffa.cabaca.ui.feature.listbook.ListBookViewModel
import com.hellodiffa.cabaca.ui.feature.menu.MenuViewModel
import com.hellodiffa.cabaca.ui.feature.writerdetail.WriterViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MenuViewModel(androidApplication(), get())
    }
    viewModel {
        ListBookViewModel(androidApplication(), get())
    }
    viewModel {
        BookDetailViewModel(androidApplication(), get())
    }
    viewModel {
        WriterViewModel(androidApplication(), get())
    }
}