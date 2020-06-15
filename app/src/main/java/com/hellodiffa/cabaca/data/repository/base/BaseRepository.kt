package com.hellodiffa.cabaca.data.repository.base

import com.hellodiffa.cabaca.common.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

abstract class BaseRepository() {

    protected suspend fun <L, R> singleSource(
        databaseQuery: () -> Flow<L>,
        networkCall: suspend () -> ResultState<R>,
        saveCallResult: suspend (R) -> Unit
    ): Flow<ResultState<L>> =
        flow {

            emit(ResultState.loading<L>())


            val source = databaseQuery.invoke().map {
                ResultState.success(it)
            }

            delay(1_500)

            val responseStatus = networkCall.invoke()

            if (responseStatus.status == ResultState.Status.SUCCESS) {
                responseStatus.data?.let { data -> saveCallResult(data) }
            } else if (responseStatus.status == ResultState.Status.ERROR) {
                emit(ResultState.error<L>(responseStatus.message))
            }

            source.apply {
                emitAll(this)
            }
        }
}