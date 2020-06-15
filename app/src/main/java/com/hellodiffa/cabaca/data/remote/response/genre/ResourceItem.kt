package com.hellodiffa.cabaca.data.remote.response.genre

import com.squareup.moshi.Json

data class ResourceItem(

	@Json(name="icon_url")
	val iconUrl: String,

	@Json(name="count")
	val count: Int,

	@Json(name="id")
	val id: Long,

	@Json(name="title")
	val title: String
)