package com.hellodiffa.cabaca.data.remote.response.newbook

import com.squareup.moshi.Json

data class Time(

	@Json(name="viewer")
	val viewer: Double? = null,

	@Json(name="chapter")
	val chapter: Double? = null,

	@Json(name="book_official")
	val bookOfficial: Double? = null,

	@Json(name="chapter_book")
	val chapterBook: Double? = null,

	@Json(name="chapter_new")
	val chapterNew: Double? = null,

	@Json(name="rating")
	val rating: Double? = null,

	@Json(name="user")
	val user: Double? = null
)