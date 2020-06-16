package com.hellodiffa.cabaca.data.remote.response.detailwriter

import com.squareup.moshi.Json

data class KaryaItem(

	@Json(name="Writer_by_writer_id")
	val writerByWriterId: WriterByWriterId? = null,

	@Json(name="cover_url")
	val coverUrl: String? = null,

	@Json(name="created_at")
	val createdAt: String? = null,

	@Json(name="isNew")
	val isNew: Boolean? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="schedule_task")
	val scheduleTask: String? = null,

	@Json(name="is_update")
	val isUpdate: Boolean? = null,

	@Json(name="bab_count")
	val babCount: Int? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="rate_sum")
	val rateSum: Double? = null,

	@Json(name="writer_id")
	val writerId: Int? = null,

	@Json(name="view_count")
	val viewCount: Int? = null,

	@Json(name="chapter_count")
	val chapterCount: Int? = null,

	@Json(name="status")
	val status: String? = null
)