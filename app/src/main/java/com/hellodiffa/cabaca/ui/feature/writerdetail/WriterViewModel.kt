package com.hellodiffa.cabaca.ui.feature.writerdetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.data.remote.response.detailwriter.Result
import com.hellodiffa.cabaca.data.repository.BookRepository
import com.hellodiffa.cabaca.ui.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WriterViewModel constructor(
    application: Application,
    private val repository: BookRepository
) : BaseViewModel(application) {

    private val _writer = MutableLiveData<ResultState<Result>>()
    val writer: LiveData<ResultState<Result>> get() = _writer

    internal fun getWriterDetail(id: String) {
        viewModelScope.launch {
            _writer.postValue(ResultState.loading())
            delay(1_500)
            try {
                _writer.postValue(ResultState.success(repository.loadWriterDetail(id).data?.result))
            } catch (e: Exception) {
                _writer.postValue(ResultState.error(e.message))
            }
        }
    }
}