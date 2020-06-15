package com.hellodiffa.cabaca.data.remote.response.detail

import com.squareup.moshi.Json

data class GenresItem(

	@Json(name="icon_url")
	val iconUrl: String? = null,

	@Json(name="is_primary")
	val isPrimary: Int? = null,

	@Json(name="count")
	val count: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="title")
	val title: String? = null
)