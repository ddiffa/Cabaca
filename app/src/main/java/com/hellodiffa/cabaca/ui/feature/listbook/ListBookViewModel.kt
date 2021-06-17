package com.hellodiffa.cabaca.ui.feature.listbook

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.data.local.entity.book.BookEntity
import com.hellodiffa.cabaca.data.remote.response.bookbygenre.ResultItem
import com.hellodiffa.cabaca.data.repository.BookRepository
import com.hellodiffa.cabaca.ui.base.BaseViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class ListBookViewModel constructor(
    application: Application,
    private val repository: BookRepository
) : BaseViewModel(application) {

    private val _books = MutableLiveData<ResultState<List<ResultItem>>>()
    val books: LiveData<ResultState<List<ResultItem>>> get() = _books

    internal fun getBookByGenre(genreId: String) {
        viewModelScope.launch(Dispatchers.Main) {
            _books.postValue(ResultState.loading())
            delay(1_500)
            try{
                val result = async(Dispatchers.IO) {
                    repository.loadBookByIdGenre(genreId)

                }
                _books.postValue(ResultState.success(result.await().data?.result))
            }catch (e: Exception){
                _books.postValue(ResultState.error(e.message))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}