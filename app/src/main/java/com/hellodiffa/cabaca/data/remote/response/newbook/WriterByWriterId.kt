package com.hellodiffa.cabaca.data.remote.response.newbook

import com.squareup.moshi.Json

data class WriterByWriterId(

    @Json(name="user_id")
	val userId: Int? = null,

    @Json(name="kelas")
	val kelas: String? = null,

    @Json(name="created_at")
	val createdAt: String? = null,

    @Json(name="id")
	val id: Int? = null,

    @Json(name="schedule_task")
	val scheduleTask: String? = null,

    @Json(name="type")
	val type: String? = null,

    @Json(name="User_by_user_id")
	val userByUserId: UserByUserId? = null,

    @Json(name="status")
	val status: Any? = null,

    @Json(name="royalty_id")
	val royaltyId: Any? = null
)