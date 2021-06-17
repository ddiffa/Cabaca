package com.hellodiffa.cabaca.ui.feature.bookdetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.data.remote.response.detail.DetailBookResponse
import com.hellodiffa.cabaca.data.repository.BookRepository
import com.hellodiffa.cabaca.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class BookDetailViewModel constructor(
    application: Application,
    private val repository: BookRepository
) : BaseViewModel(application) {


    private val _books = MutableLiveData<ResultState<DetailBookResponse>>()
    val books: LiveData<ResultState<DetailBookResponse>> get() = _books


    internal fun getBookDetail(id: String) {
        viewModelScope.launch {
            val result = async(Dispatchers.IO) {
                repository.loadBooksDetail(id)
            }
            _books.postValue(result.await())
        }
    }


}