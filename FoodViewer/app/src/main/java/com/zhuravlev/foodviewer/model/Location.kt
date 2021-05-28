package com.zhuravlev.foodviewer.model

import androidx.room.Entity

@Entity(tableName = "location")
data class Location(val id: String, val name: String, val selected: Boolean = false)
