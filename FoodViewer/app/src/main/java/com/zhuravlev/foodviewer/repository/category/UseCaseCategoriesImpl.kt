package com.zhuravlev.foodviewer.repository.category

import com.zhuravlev.foodviewer.database.DishDAO
import com.zhuravlev.foodviewer.database.LocationDAO
import com.zhuravlev.foodviewer.model.Category
import com.zhuravlev.foodviewer.model.Dish
import com.zhuravlev.foodviewer.net.NetworkService
import com.zhuravlev.foodviewer.repository.location.UseCaseLocation
import javax.inject.Inject

class UseCaseCategoriesImpl (
    private val dishDAO: DishDAO,
    private val useCaseLocation: UseCaseLocation,
    private val networkService: NetworkService): UseCaseCategories {
    override fun getCategories(): List<Category> {
        val dishes = dishDAO.getAll()
        return if (dishes.isEmpty()) {
            val newDishes = networkService.getMenuByLocations(useCaseLocation.getLocation())
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
