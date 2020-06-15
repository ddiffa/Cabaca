package com.hellodiffa.cabaca.data.remote.response.bookbygenre

import com.squareup.moshi.Json

data class BookByGenreResponse(

	@Json(name="result")
	val result: List<ResultItem>,

	@Json(name="test")
	val test: Test? = null,

	@Json(name="success")
	val success: Boolean? = null
)