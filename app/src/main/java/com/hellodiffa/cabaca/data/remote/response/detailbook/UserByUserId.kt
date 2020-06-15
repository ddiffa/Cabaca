package com.hellodiffa.cabaca.data.remote.response.detailbook

import com.squareup.moshi.Json

data class UserByUserId(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="photo_url")
	val photoUrl: String? = null,

	@Json(name="username")
	val username: String? = null
)