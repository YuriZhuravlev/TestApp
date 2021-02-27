package com.zhuravlev.recyclerviewexample.model

import com.google.gson.annotations.SerializedName

data class Geo(

        @field:SerializedName("lon")
        val lon: Double? = null,

        @field:SerializedName("lat")
        val lat: Double? = null
)