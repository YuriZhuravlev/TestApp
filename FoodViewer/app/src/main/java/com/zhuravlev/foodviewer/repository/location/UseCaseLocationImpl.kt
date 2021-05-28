package com.zhuravlev.foodviewer.repository.location

import com.zhuravlev.foodviewer.database.DishDAO
import com.zhuravlev.foodviewer.database.LocationDAO
import com.zhuravlev.foodviewer.model.Location
import com.zhuravlev.foodviewer.net.NetworkService
import javax.inject.Inject

class UseCaseLocationImpl @Inject constructor(
    private val dishDAO: DishDAO,
    private val locationDAO: LocationDAO,
    private val networkService: NetworkService
) : UseCaseLocation {
    private var currentLocation: Location? = null

    override fun getAllLocations(): List<Location> {
        return locationDAO.getAll()
    }

    override fun getLocation(): Location {
        return if (currentLocation == null) {
            val locations = networkService.getLocations()
            locationDAO.insertLocations(locations)
            currentLocation = locations[0].copy(selected = true)
            setLocation(currentLocation!!)
            currentLocation!!
        } else {
            currentLocation!!
        }
    }

    override fun setLocation(location: Location): Boolean {
        return try {
            locationDAO.updateLocationById(
                currentLocation!!.id,
                currentLocation!!.copy(selected = false)
            )
            currentLocation = location.copy(selected = true)
            locationDAO.updateLocationById(currentLocation!!.id, currentLocation!!)
            dishDAO.clearAll()
            dishDAO.insertDishes(networkService.getMenuByLocations(currentLocation!!))
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}