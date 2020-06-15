package com.hellodiffa.cabaca.data.remote.response.detail

import com.squareup.moshi.Json

data class RelatedByBookItem(

	@Json(name="cover_url")
	val coverUrl: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="title")
	val title: String? = null
)