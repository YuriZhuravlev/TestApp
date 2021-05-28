package com.zhuravlev.foodviewer.repository.dish

import com.zhuravlev.foodviewer.model.Dish

interface UseCaseDishes {
    fun getDishes(): List<Dish>
    fun getDishById(id: String): Dish
}