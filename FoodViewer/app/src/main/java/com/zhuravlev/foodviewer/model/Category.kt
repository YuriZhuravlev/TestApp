package com.zhuravlev.foodviewer.model

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter

// order - можно использовать для группировки - сначала "основные блюда", потом "закуски", "кофе" и т.д.
// local name можно парсить в extension функции ссылаясь на контекст
enum class Category(val order: Int) {
    PIZZA(0),
    COMBO(1),
    DESERT(2),
    DRINK(3)
}

@ProvidedTypeConverter
object CategoryConverter {
    @TypeConverter
    fun toCategory(value: Int) = enumValues<Category>()[value]

    @TypeConverter
    fun fromCategory(value: Category) = value.ordinal
}