package com.hellodiffa.cabaca.data.remote.response.detail

import com.squareup.moshi.Json

data class BookChapterByBookIdItem(

	@Json(name="new")
	val jsonMemberNew: Boolean? = null,

	@Json(name="like_count")
	val likeCount: Int? = null,

	@Json(name="is_readed")
	val isReaded: Boolean? = null,

	@Json(name="created_at")
	val createdAt: String? = null,

	@Json(name="book_id")
	val bookId: Int? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="schedule_task")
	val scheduleTask: String? = null,

	@Json(name="view_by_user")
	val viewByUser: Int? = null,

	@Json(name="is_warning")
	val isWarning: Any? = null,

	@Json(name="price")
	val price: Int? = null,

	@Json(name="chapter_sequence")
	val chapterSequence: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="view_count")
	val viewCount: Int? = null,

	@Json(name="is_purchased")
	val isPurchased: Boolean? = null
)