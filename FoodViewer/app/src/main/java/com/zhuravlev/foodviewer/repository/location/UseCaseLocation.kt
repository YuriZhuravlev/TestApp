package com.zhuravlev.foodviewer.repository.location

import com.zhuravlev.foodviewer.model.Location

interface UseCaseLocation {
    fun getAllLocations(): List<Location>
    fun getLocation(): Location
    fun setLocation(): Boolean
}