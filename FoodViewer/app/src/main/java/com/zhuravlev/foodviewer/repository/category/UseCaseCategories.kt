package com.zhuravlev.foodviewer.repository.category

import com.zhuravlev.foodviewer.model.Category

interface UseCaseCategories {
    fun getCategories(): List<Category>
}