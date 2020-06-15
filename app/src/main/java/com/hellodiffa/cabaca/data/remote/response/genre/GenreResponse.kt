package com.hellodiffa.cabaca.data.remote.response.genre

import com.squareup.moshi.Json

data class GenreResponse(

	@Json(name="resource")
	val resource: List<ResourceItem>
)