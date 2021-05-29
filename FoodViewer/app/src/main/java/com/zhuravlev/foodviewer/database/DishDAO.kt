package com.zhuravlev.foodviewer.database

import androidx.room.*
import com.google.android.material.circularreveal.CircularRevealHelper
import com.zhuravlev.foodviewer.model.CategoryConverter
import com.zhuravlev.foodviewer.model.Dish

@Dao
interface DishDAO {
    @Query("SELECT * FROM dish")
    fun getAll(): List<Dish>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDishes(list: List<Dish>)

    @Query("DELETE FROM dish")
    fun clearAll()
}