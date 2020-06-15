package com.hellodiffa.cabaca.data.remote.response.detailbook

import com.squareup.moshi.Json

data class HashtagsItem(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null
)