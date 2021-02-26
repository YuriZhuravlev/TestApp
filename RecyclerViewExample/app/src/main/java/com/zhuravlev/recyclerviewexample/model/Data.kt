package com.zhuravlev.recyclerviewexample.model

import com.google.gson.annotations.SerializedName

data class Data(

        @field:SerializedName("geo")
        val geo: Geo? = null,

        @field:SerializedName("objects")
        val objects: List<Service?>? = null,

        @field:SerializedName("categories")
        val categories: List<CategoriesItem?>? = null
)