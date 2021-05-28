package com.zhuravlev.foodviewer.repository.dish

import com.zhuravlev.foodviewer.database.DishDAO
import com.zhuravlev.foodviewer.database.LocationDAO
import com.zhuravlev.foodviewer.model.Dish
import com.zhuravlev.foodviewer.net.NetworkService
import com.zhuravlev.foodviewer.repository.location.UseCaseLocation
import javax.inject.Inject

class UseCaseDishesImpl (
    private val dishDAO: DishDAO,
    private val useCaseLocation: UseCaseLocation,
    private val networkService: NetworkService
) : UseCaseDishes {
    override fun getDishes(): List<Dish> {
        val dishes = dishDAO.getAll()
        return if (dishes.isEmpty()) {
            val newDishes = networkService.getMenuByLocations(useCaseLocation.getLocation())
            dishDAO.insertDishes(newDishes)
            newDishes
        } else {
            dishDAO.getAll()
        }
    }

    override fun getDishById(id: String): Dish {
        throw (Throwable("Not yet implemented"))
    }
}