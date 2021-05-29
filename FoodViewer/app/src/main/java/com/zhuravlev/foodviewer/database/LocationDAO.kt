package com.zhuravlev.foodviewer.database

import androidx.room.*
import com.zhuravlev.foodviewer.model.Location

@Dao
interface LocationDAO {
    @Query("SELECT * FROM location")
    fun getAll(): List<Location>

    @Query("SELECT * FROM location WHERE selected = 1")
    fun getCurrentLocation(): Location

    @Update
    fun updateLocationById(location: Location)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocations(list: List<Location>)
}