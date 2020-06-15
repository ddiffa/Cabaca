package com.hellodiffa.cabaca.data.remote.response.newbook

import com.squareup.moshi.Json

data class UserByUserId(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null
)