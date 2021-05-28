package com.zhuravlev.foodviewer.net

import com.zhuravlev.foodviewer.model.Category
import com.zhuravlev.foodviewer.model.Dish
import com.zhuravlev.foodviewer.model.Location

class MockNetworkService : NetworkService {
    override fun getLocations(): List<Location> {
        return listOf(
            Location("1", "Анапа"),
            Location("2", "Краснодар"),
            Location("3", "Липецк"),
            Location("4", "Москва"),
            Location("5", "Новосибирск"),
            Location("6", "Санкт-Петербург")
        )
    }

    override fun getMenuByLocations(location: Location): List<Dish> {
        return listOf(
            Dish(
                "${100 + location.id.toInt()}",
                "Пицца-${location.name}",
                "Эксклюзивно для города ${location.name}",
                "от 445 ₽",
                Category.PIZZA
            ),
            Dish("1", "Ветчина и грибы", "Ветчина, шампиньоны...", "от 345 ₽", Category.PIZZA),
            Dish("2", "Баварские колбаски", "Баварские колбаски...", "от 345 ₽", Category.PIZZA),
            Dish(
                "3",
                "Нежный лосось",
                "Лосось, томаты, оливки, соус песто...",
                "от 450 ₽",
                Category.PIZZA
            ),
            Dish("4", "Комбо за 300", "", "300 ₽", Category.COMBO),
            Dish("5", "Комбо 3 пиццы", "", "999 ₽", Category.COMBO),
            Dish("6", "Мороженное обычное", "от 75 ₽", "", Category.DESERT),
            Dish("7", "Мороженное необычное", "от 200 ₽", "", Category.DESERT),
            Dish("8", "Квас", "", "от 40 ₽", Category.DRINK),
            Dish("9", "Кофе", "", "от 75 ₽", Category.DRINK)
        )
    }
}