package com.zhuravlev.foodviewer.repository.location

import com.zhuravlev.foodviewer.database.DishDAO
import com.zhuravlev.foodviewer.database.LocationDAO
import com.zhuravlev.foodviewer.model.Location
import com.zhuravlev.foodviewer.net.NetworkService

class UseCaseLocationImpl(
    private val dishDAO: DishDAO,
    private val locationDAO: LocationDAO,
    private val networkService: NetworkService
) : UseCaseLocation {
    private var currentLocation: Location? = null
    override fun getAllLocations(): List<Location> {
        var all = locationDAO.getAll()
        if (all.isEmpty()) {
            all = networkService.getLocations()
            locationDAO.insertLocations(all)
        }
        if (currentLocation == null) {
            setLocation(all.findLast { it.selected } ?: all[0])
        }
        return all
    }

    override fun getLocation(): Location {
        return currentLocation ?: let {
            val all = getAllLocations()
            if (currentLocation == null) {
                setLocation(all.first())
            }
            currentLocation!!
        }
    }

    override fun setLocation(location: Location): Boolean {
        if (location == currentLocation) {
            return true
        }
        return try {
            currentLocation?.let {
                locationDAO.updateLocationById(it.copy(selected = false))
            }
            currentLocation = location.copy(selected = true)
            locationDAO.updateLocationById(currentLocation!!)
            dishDAO.clearAll()
            dishDAO.insertDishes(networkService.getMenuByLocations(currentLocation!!))
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }


//    override fun getAllLocations(): List<Location> {
//        var all = locationDAO.getAll()
//        if (all.isEmpty()) {
//            all = networkService.getLocations()
//        }
//        if (currentLocation == null) {
//            currentLocation = all.findLast { it.selected } ?: all.first()
//        }
//        return all
//    }
//
//    override fun getLocation(): Location {
//        return if (currentLocation == null) {
//            getAllLocations()
//            currentLocation!!
//        } else {
//            currentLocation!!
//        }
//    }
//
//    override fun setLocation(location: Location): Boolean {
//        return try {
//            if (location == currentLocation) {
//                return true
//            }
//            locationDAO.updateLocationById(currentLocation!!.copy(selected = false))
//            currentLocation = location.copy(selected = true)
//            locationDAO.updateLocationById(currentLocation!!)
//            dishDAO.clearAll()
//            dishDAO.insertDishes(networkService.getMenuByLocations(currentLocation!!))
//            true
//        } catch (e: Exception) {
//            e.printStackTrace()
//            false
//        }
//    }
}