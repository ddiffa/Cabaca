package com.hellodiffa.cabaca.data.remote.response.detailbook

import com.squareup.moshi.Json

data class BookDetailResponse(

	@Json(name="result")
	val result: Result? = null,

	@Json(name="success")
	val success: Boolean? = null
)