package com.zhuravlev.foodviewer.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.zhuravlev.foodviewer.model.Location

@Dao
interface LocationDAO {
    @Query("SELECT * FROM location")
    fun getAll(): List<Location>

    @Query("SELECT * FROM location WHERE selected = 1")
    fun getCurrentLocation(): Location

    @Update
    fun updateLocationById(id: String, location: Location)

    @Insert
    fun insertLocations(list: List<Location>)
}