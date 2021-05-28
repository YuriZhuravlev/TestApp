package com.zhuravlev.foodviewer.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zhuravlev.foodviewer.model.Dish
import com.zhuravlev.foodviewer.model.Location

@Database(entities = [Dish::class, Location::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun getDishDAO(): DishDAO
    abstract fun getLocationDAO(): LocationDAO
}