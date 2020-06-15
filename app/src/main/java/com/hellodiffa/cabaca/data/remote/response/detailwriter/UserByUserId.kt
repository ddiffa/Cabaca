package com.hellodiffa.cabaca.data.remote.response.detailwriter

import com.squareup.moshi.Json

data class UserByUserId(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="email")
	val email: String? = null,

	@Json(name="username")
	val username: String? = null
)