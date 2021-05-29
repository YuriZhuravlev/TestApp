package com.zhuravlev.foodviewer.utils

import android.content.Context
import com.zhuravlev.foodviewer.R
import com.zhuravlev.foodviewer.model.Category


fun localizationCategory(context: Context, category: Category): String {
    return when (category) {
        Category.PIZZA -> context.getString(R.string.category_pizza)
        Category.COMBO -> context.getString(R.string.category_combo)
        Category.DRINK -> context.getString(R.string.category_drink)
        Category.DESSERT -> context.getString(R.string.category_dessert)
    }
}