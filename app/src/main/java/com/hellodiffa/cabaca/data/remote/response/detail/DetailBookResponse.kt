package com.hellodiffa.cabaca.data.remote.response.detail

import com.squareup.moshi.Json

data class DetailBookResponse(

	@Json(name="result")
	val result: Result? = null,

	@Json(name="success")
	val success: Boolean? = null
)