package com.zhuravlev.recyclerviewexample.model

import com.google.gson.annotations.SerializedName

data class CategoriesItem(

		@field:SerializedName("color")
		val color: String? = null,

		@field:SerializedName("name")
		val name: String? = null,

		@field:SerializedName("icon")
		val icon: String? = null,

		@field:SerializedName("count")
		val count: Int? = null,

		@field:SerializedName("type")
		val type: String? = null
)