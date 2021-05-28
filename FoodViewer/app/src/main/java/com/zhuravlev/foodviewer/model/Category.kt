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
class CategoryConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun toCategory(value: String): Category = Category.valueOf(value)

        @TypeConverter
        @JvmStatic
        fun fromCategory(value: Category): String = value.name
    }
}
/*
@ProvidedTypeConverter
class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromTimestamp(value: Long?): Date? {
            return value?.let { Date(it) }
        }

        @TypeConverter
        @JvmStatic
        fun dateToTimestamp(date: Date?): Long? {
            return date?.time
        }
    }
}
 */