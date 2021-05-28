package com.zhuravlev.foodviewer.database

import androidx.room.Database
import com.zhuravlev.foodviewer.model.Dish
import com.zhuravlev.foodviewer.model.Location

@Database(entities = [Dish::class, Location::class], version = 1)
abstract class Database {
    abstract fun getDishDAO(): DishDAO
    abstract fun getLocationDAO(): LocationDAO
}