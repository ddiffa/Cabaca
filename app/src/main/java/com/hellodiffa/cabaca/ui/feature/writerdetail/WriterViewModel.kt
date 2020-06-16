package com.hellodiffa.cabaca.ui.feature.writerdetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.data.remote.response.detailwriter.Result
import com.hellodiffa.cabaca.data.remote.response.detailwriter.WriterDetailResponse
import com.hellodiffa.cabaca.data.repository.BookRepository
import com.hellodiffa.cabaca.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WriterViewModel constructor(
    application: Application,
    private val repository: BookRepository
) : BaseViewModel(application) {

    private val _writer = MutableLiveData<ResultState<WriterDetailResponse>>()
    val writer: LiveData<ResultState<WriterDetailResponse>> get() = _writer

    internal fun getWriterDetail(id: String) {
        viewModelScope.launch(Dispatchers.Main) {
                val result = async(Dispatchers.IO) {
                    repository.loadWriterDetail(id)
                }
                _writer.postValue(result.await())
        }
    }
}