package com.zhuravlev.recyclerviewexample.model

import com.google.gson.annotations.SerializedName

data class TurResponse(

        @field:SerializedName("data")
        val data: Data? = null,

        @field:SerializedName("success")
        val success: Boolean? = null,

        @field:SerializedName("time")
        val time: String? = null,

        @field:SerializedName("error")
        val error: Any? = null
)