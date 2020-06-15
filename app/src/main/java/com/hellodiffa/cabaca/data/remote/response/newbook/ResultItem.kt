package com.hellodiffa.cabaca.data.remote.response.newbook

import com.squareup.moshi.Json

data class ResultItem(

    @Json(name="Writer_by_writer_id")
	val writerByWriterId: WriterByWriterId? = null,

    @Json(name="cover_url")
	val coverUrl: String? = null,

    @Json(name="created_at")
	val createdAt: String? = null,

    @Json(name="book_id")
	val bookId: Int? = null,

    @Json(name="isNew")
	val isNew: Boolean? = null,

    @Json(name="title")
	val title: String? = null,

    @Json(name="schedule_task")
	val scheduleTask: String? = null,

    @Json(name="is_update")
	val isUpdate: Boolean? = null,

    @Json(name="id")
	val id: Int? = null,

    @Json(name="category")
	val category: Any? = null,

    @Json(name="rate_sum")
	val rateSum: Int? = null,

    @Json(name="writer_id")
	val writerId: Int? = null,

    @Json(name="view_count")
	val viewCount: Int? = null,

    @Json(name="chapter_count")
	val chapterCount: Int? = null,

    @Json(name="status")
	val status: String? = null
)