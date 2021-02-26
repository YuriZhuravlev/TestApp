package com.zhuravlev.recyclerviewexample.model

import com.google.gson.annotations.SerializedName

data class Service(

        @field:SerializedName("image")
        val image: String? = null,

        @field:SerializedName("color")
        val color: String? = null,

        @field:SerializedName("working_hours")
        val workingHours: List<WorkingHoursItem?>? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("icon")
        val icon: String? = null,

        @field:SerializedName("description")
        val description: String? = null,

        @field:SerializedName("lon")
        val lon: Double? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("lat")
        val lat: Double? = null
)