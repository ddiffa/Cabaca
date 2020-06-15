package com.hellodiffa.cabaca.data.remote.response.bookbygenre

import com.squareup.moshi.Json

data class GenreByGenreId(

	@Json(name="icon_url")
	val iconUrl: String? = null,

	@Json(name="count")
	val count: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="title")
	val title: String? = null
)