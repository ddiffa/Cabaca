package com.hellodiffa.cabaca.data.remote.response.detail

import com.squareup.moshi.Json

data class Result(

	@Json(name="Writer_by_writer_id")
	val writerByWriterId: WriterByWriterId? = null,

	@Json(name="is_contract_actived")
	val isContractActived: Boolean? = null,

	@Json(name="hashtags")
	val hashtags: List<HashtagsItem?>? = null,

	@Json(name="challenge_id")
	val challengeId: Any? = null,

	@Json(name="created_at")
	val createdAt: String? = null,

	@Json(name="voted")
	val voted: Boolean? = null,

	@Json(name="BookChapter_by_book_id")
	val bookChapterByBookId: List<BookChapterByBookIdItem?>? = null,

	@Json(name="url_landing")
	val urlLanding: String? = null,

	@Json(name="title")
	val title: String,

	@Json(name="download")
	val download: Any? = null,

	@Json(name="updated_at")
	val updatedAt: String? = null,

	@Json(name="reviews")
	val reviews: List<Any?>? = null,

	@Json(name="happyhour")
	val happyhour: Boolean? = null,

	@Json(name="genres")
	val genres: List<GenresItem?>? = null,

	@Json(name="is_update")
	val isUpdate: Boolean? = null,

	@Json(name="Related_by_book")
	val relatedByBook: List<RelatedByBookItem?>? = null,

	@Json(name="book_url")
	val bookUrl: String? = null,

	@Json(name="id")
	val id: Int,

	@Json(name="full_purchase")
	val fullPurchase: Boolean? = null,

	@Json(name="writer_id")
	val writerId: Int? = null,

	@Json(name="vote_count")
	val voteCount: String? = null,

	@Json(name="auto_buy_chapter")
	val autoBuyChapter: Boolean? = null,

	@Json(name="User_review")
	val userReview: String? = null,

	@Json(name="chapter_count")
	val chapterCount: Int? = null,

	@Json(name="decimal_rate")
	val decimalRate: Double? = null,

	@Json(name="cover_url")
	val coverUrl: String,

	@Json(name="average_rate")
	val averageRate: Int? = null,

	@Json(name="synopsis")
	val synopsis: String,

	@Json(name="isNew")
	val isNew: Boolean? = null,

	@Json(name="schedule_task")
	val scheduleTask: String? = null,

	@Json(name="time_to_vote")
	val timeToVote: Boolean? = null,

	@Json(name="full_purchased")
	val fullPurchased: Boolean? = null,

	@Json(name="nominasi")
	val nominasi: Any? = null,

	@Json(name="chapter_paid_count")
	val chapterPaidCount: Int? = null,

	@Json(name="daily")
	val daily: String? = null,

	@Json(name="is_free")
	val isFree: Boolean? = null,

	@Json(name="schedule_daily")
	val scheduleDaily: Int? = null,

	@Json(name="category")
	val category: Any? = null,

	@Json(name="full_price")
	val fullPrice: Int? = null,

	@Json(name="view_count")
	val viewCount: Int? = null,

	@Json(name="status")
	val status: String? = null,

	@Json(name="desc")
	val desc: String? = null
)