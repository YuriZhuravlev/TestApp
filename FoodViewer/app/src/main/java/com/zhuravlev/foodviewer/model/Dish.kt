package com.zhuravlev.foodviewer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dish")
data class Dish(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val price: String,
    val category: Category,
    val imageUrl: String? = null
)