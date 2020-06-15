package com.hellodiffa.cabaca.data.remote.response.bookx

data class WriterByWriterId(
	val userId: Int?=null,
	val id: Int?=null,
	val userByUserId: UserByUserId?=null,
	val status: Any?=null
)
