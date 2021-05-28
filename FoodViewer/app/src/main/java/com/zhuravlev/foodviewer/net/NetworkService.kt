package com.zhuravlev.foodviewer.net

import com.zhuravlev.foodviewer.model.Dish
import com.zhuravlev.foodviewer.model.Location

/**
 * Я пытался найти открытое api, но не нашёл, сделал эмуляцию.
 * Были два варианта, конечно, но решил рационально распределить время
 * 1) https://documenu.com/dashboard/apipreview
 * 2) https://rapidapi.com/ru/restaurantmenus/api/us-restaurant-menus
 */
interface NetworkService {
    fun getLocations(): List<Location>
    fun getMenuByLocations(location: Location): List<Dish>
}