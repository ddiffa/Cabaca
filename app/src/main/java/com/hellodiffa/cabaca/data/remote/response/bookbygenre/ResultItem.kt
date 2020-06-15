package com.hellodiffa.cabaca.data.remote.response.bookbygenre

import com.squareup.moshi.Json

data class ResultItem(

	@Json(name="Writer_by_writer_id")
	val writerByWriterId: WriterByWriterId? = null,

	@Json(name="cover_url")
	val coverUrl: String,

	@Json(name="created_at")
	val createdAt: String? = null,

	@Json(name="isNew")
	val isNew: Boolean,

	@Json(name="title")
	val title: String,

	@Json(name="schedule_task")
	val scheduleTask: String? = null,

	@Json(name="genre_id")
	val genreId: Int,

	@Json(name="Genre_by_genre_id")
	val genreByGenreId: GenreByGenreId? = null,

	@Json(name="is_update")
	val isUpdate: Boolean? = null,

	@Json(name="id")
	val id: Int,

	@Json(name="rate_sum")
	val rateSum: Double? = null,

	@Json(name="writer_id")
	val writerId: Int? = null,

	@Json(name="view_count")
	val viewCount: Int? = null,

	@Json(name="chapter_count")
	val chapterCount: Int? = null,

	@Json(name="status")
	val status: String? = null,

	@Json(name="book_url")
	val bookUrl: String? = null
)