package com.zhuravlev.foodviewer.repository.category

import com.zhuravlev.foodviewer.database.DishDAO
import com.zhuravlev.foodviewer.database.LocationDAO
import com.zhuravlev.foodviewer.model.Category
import com.zhuravlev.foodviewer.model.Dish
import com.zhuravlev.foodviewer.net.NetworkService
import javax.inject.Inject

class UseCaseCategoriesImpl @Inject constructor(
    private val dishDAO: DishDAO,
    private val locationDAO: LocationDAO,
    private val networkService: NetworkService): UseCaseCategories {
    override fun getCategories(): List<Category> {
        val dishes = dishDAO.getAll()
        return if (dishes.isEmpty()) {
            val newDishes = networkService.getMenuByLocations(locationDAO.getCurrentLocation())
            dishDAO.insertDishes(newDishes)
            newDishes.getCategories()
        } else {
            dishDAO.getAll().getCategories()
        }
    }

}

private fun List<Dish>.getCategories(): List<Category> {
    return this.groupBy { it.category }.keys.toList().sortedBy { it.order }
}
