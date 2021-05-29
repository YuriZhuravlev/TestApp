package com.zhuravlev.foodviewer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class Location(@PrimaryKey val id: String, val name: String, val selected: Boolean = false)
