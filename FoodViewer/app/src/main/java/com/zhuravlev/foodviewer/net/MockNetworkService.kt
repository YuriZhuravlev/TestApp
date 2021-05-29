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
            Dish(
                "1", "Ветчина и грибы", "Ветчина, шампиньоны...", "от 345 ₽",
                Category.PIZZA,
                "https://shlpn.ru/assets/images/products/867/488-1.png"
            ),
            Dish(
                "2",
                "Баварские колбаски",
                "Баварские колбаски...",
                "от 345 ₽",
                Category.PIZZA,
                "https://sorento.pizza/image/saransk/menu/pitstsa/bavarskaya/upload/aa7ea3f46268db840e6eff43f3196c76606c5207.jpg"
            ),
            Dish(
                "3",
                "Нежный лосось",
                "Лосось, томаты, оливки, соус песто...",
                "от 450 ₽",
                Category.PIZZA,
                "https://itd1.mycdn.me/image?id=866254520420&t=20&plc=MOBILE&tkn=*prQM01kTugoDOaAIVZWhl6hpusY"
            ),
            Dish(
                "4",
                "Комбо за 300",
                "Отличный выбор для обеда",
                "300 ₽",
                Category.COMBO,
                "https://gtwfilesie.grandtheftwiki.com/WellStackedPizza-GTASA-DoubleD-Luxe.jpg"
            ),
            Dish(
                "5",
                "Комбо 3 пиццы",
                "Возьмите 3 пиццы 25 см со скидкой для большой компании",
                "999 ₽",
                Category.COMBO,
                "https://gtwfilesie.grandtheftwiki.com/Cluckin%27Bell-GTASA-Cluckin%27HugeMeal.jpg"
            ),
            Dish(
                "6",
                "Мороженное обычное",
                "",
                "от 75 ₽",
                Category.DESSERT,
                "https://gajmorit.com/userfiles/content-images/angina/71.jpg"
            ),
            Dish(
                "7",
                "Мороженное необычное",
                "",
                "от 200 ₽",
                Category.DESSERT,
                "https://3.bp.blogspot.com/-w5RVptuhyrc/WFf_avxKl1I/AAAAAAAAADs/PLmLS-V6zYw57DZyAYLcUAjwXWn1arxqACLcB/s320/1435831822_screenshot_10.jpg"
            ),
            Dish(
                "8",
                "Квас",
                "",
                "от 40 ₽",
                Category.DRINK,
                "https://istihi.ru/content/images/essence/custom_poem/7/2/72830/29814.jpg"
            ),
            Dish(
                "9",
                "Кофе",
                "",
                "от 75 ₽",
                Category.DRINK,
                "https://eda-land.ru/images/article/orig/2018/06/kofe-bez-kofeina-poleznye-svojstva-i-protivopokazaniya.jpg"
            )
        )
    }
}