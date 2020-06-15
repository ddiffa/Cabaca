package com.hellodiffa.cabaca.data.remote.response.detailwriter

import com.squareup.moshi.Json

data class Result(

	@Json(name="birthday")
	val birthday: String? = null,

	@Json(name="gender")
	val gender: String? = null,

	@Json(name="count_following")
	val countFollowing: Int? = null,

	@Json(name="current_level")
	val currentLevel: Int? = null,

	@Json(name="Writer_by_user_id")
	val writerByUserId: WriterByUserId? = null,

	@Json(name="reading_list")
	val readingList: List<Any?>? = null,

	@Json(name="writer_level")
	val writerLevel: Int? = null,

	@Json(name="phone")
	val phone: String? = null,

	@Json(name="karya")
	val karya: List<KaryaItem?>? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="following_user")
	val followingUser: List<Any?>? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="photo_url")
	val photoUrl: String? = null,

	@Json(name="deskripsi")
	val deskripsi: String? = null,

	@Json(name="writer_level_name")
	val writerLevelName: String? = null,

	@Json(name="writer_id")
	val writerId: Int? = null,

	@Json(name="count_follower")
	val countFollower: Int? = null,

	@Json(name="is_following")
	val isFollowing: Boolean? = null,

	@Json(name="email")
	val email: String? = null,

	@Json(name="username")
	val username: String? = null,

	@Json(name="link_user")
	val linkUser: String? = null,

	@Json(name="coin")
	val coin: Int? = null
)