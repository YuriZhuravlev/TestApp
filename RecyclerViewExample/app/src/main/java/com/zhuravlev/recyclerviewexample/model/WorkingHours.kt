package com.zhuravlev.recyclerviewexample.model

import com.google.gson.annotations.SerializedName

data class WorkingHoursItem(

        @field:SerializedName("days")
        val days: List<Int?>? = null,

        @field:SerializedName("from")
        val from: String? = null,

        @field:SerializedName("to")
        val to: String? = null
)