package com.hellodiffa.cabaca.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel(application: Application) : AndroidViewModel(application),
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = viewModelScope.coroutineContext + Dispatchers.IO

    inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
        return liveData(coroutineContext) {
            emitSource(block())
        }
    }

    override fun onCleared() {
        super.onCleared()
        cancel()
    }

}