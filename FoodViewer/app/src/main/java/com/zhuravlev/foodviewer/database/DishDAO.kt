package com.zhuravlev.foodviewer.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.zhuravlev.foodviewer.model.Dish

@Dao
interface DishDAO {
    @Query("SELECT * FROM dish")
    fun getAll(): List<Dish>

    @Insert
    fun insertDishes(list: List<Dish>)

    @Query("DELETE FROM dish")
    fun clearAll()
}