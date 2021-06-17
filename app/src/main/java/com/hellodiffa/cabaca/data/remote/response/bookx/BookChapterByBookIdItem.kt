package com.hellodiffa.cabaca.data.remote.response.bookx

import androidx.room.Ignore


data class BookChapterByBookIdItem(
	val jsonMemberNew: Boolean?=null,
	val likeCount: Int?=null,
	val isReaded: Boolean?=null,
	val createdAt: String?=null,
	val bookId: Int?=null,
	val title: String?=null,
	val scheduleTask: String?=null,
	val viewByUser: Int?=null,
	val isWarning: Any?=null,
	val price: Int?=null,
	val chapterSequence: Int?=null,
	val id: Int?=null,
	val viewCount: Int?=null,
	val isPurchased: Boolean?=null
)
