package com.zhuravlev.foodviewer.model

data class Dish(
    val id: String,
    val name: String,
    val description: String,
    val price: String,
    val category: Category,
    val imageUrl: String? = null
)