package com.hellodiffa.cabaca.data.remote.response.detail

import com.squareup.moshi.Json

data class HashtagsItem(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null
)