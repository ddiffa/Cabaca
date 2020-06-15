package com.hellodiffa.cabaca.ui.feature.menu

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.data.local.entity.book.BookEntity
import com.hellodiffa.cabaca.data.local.entity.genre.GenreEntity
import com.hellodiffa.cabaca.data.repository.BookRepository
import com.hellodiffa.cabaca.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MenuViewModel constructor(application: Application, private val repository: BookRepository) :
    BaseViewModel(application) {
    private val _genres = MutableLiveData<ResultState<List<GenreEntity>>>()
    val genres: LiveData<ResultState<List<GenreEntity>>> get() = _genres

    private val _books = MutableLiveData<ResultState<List<BookEntity>>>()
    val books: LiveData<ResultState<List<BookEntity>>> get() = _books

    init {

        getGenres()
        getBooks()

    }

    private fun getBooks() {
        viewModelScope.launch {
            repository.loadAllNewBook().collect {
                _books.postValue(it)
            }
        }
    }

    private fun getGenres() {
        viewModelScope.launch {
            repository.loadAllGenre().collect {
                _genres.postValue(it)
            }
        }
    }

}