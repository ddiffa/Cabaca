package com.hellodiffa.cabaca.data.remote.response.detailwriter

import com.squareup.moshi.Json

data class WriterDetailResponse(

	@Json(name="result")
	val result: Result? = null,

	@Json(name="success")
	val success: Boolean? = null
)