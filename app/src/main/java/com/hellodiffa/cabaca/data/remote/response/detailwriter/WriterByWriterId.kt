package com.hellodiffa.cabaca.data.remote.response.detailwriter

import com.squareup.moshi.Json

data class WriterByWriterId(

	@Json(name="user_id")
	val userId: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="User_by_user_id")
	val userByUserId: UserByUserId? = null,

	@Json(name="royalty_id")
	val royaltyId: Any? = null,

	@Json(name="status")
	val status: Any? = null
)