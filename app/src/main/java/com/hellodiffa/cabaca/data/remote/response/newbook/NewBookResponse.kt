package com.hellodiffa.cabaca.data.remote.response.newbook

import com.squareup.moshi.Json

data class NewBookResponse(

    @Json(name="result")
	val result: List<ResultItem>,

    @Json(name="success")
	val success: Boolean? = null,

    @Json(name="time")
	val time: Time? = null
)