package com.zhuravlev.leroy.model

import com.google.gson.annotations.SerializedName

data class CatImage(

	@field:SerializedName("x")
	val X: Double? = null,

	@field:SerializedName("y")
	val Y: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("webpurl")
	val webpurl: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
